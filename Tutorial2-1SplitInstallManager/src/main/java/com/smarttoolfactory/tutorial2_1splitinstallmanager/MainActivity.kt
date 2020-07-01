package com.smarttoolfactory.tutorial2_1splitinstallmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

class MainActivity : AppCompatActivity() {

    /**
     * SplitInstallManager for checking, installing and uninstalling dynamic feature modules
     */
    private lateinit var splitInstallManager: SplitInstallManager

    private val dynamicFeaturePhoto = "feature2_photo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        splitInstallManager = SplitInstallManagerFactory.create(applicationContext)

        findViewById<Button>(R.id.buttonPhoto).setOnClickListener {

            if (isFeatureDownloaded(dynamicFeaturePhoto)) {
                val intent = Intent()
                    .setClassName(this, "com.smarttoolfactory.feature2_photo.PhotoActivity")
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "feature is not dowloaded", Toast.LENGTH_SHORT)
                    .show()
                downloadFeature(dynamicFeaturePhoto)
            }
        }

    }


    private fun isFeatureDownloaded(featureName: String): Boolean {
        return splitInstallManager.installedModules.contains(featureName)
    }

    private fun singleFeatureInstallRequest(featureName: String): SplitInstallRequest {
        return SplitInstallRequest
            .newBuilder()
            .addModule(featureName)
            .build()
    }


    private fun downloadFeature(featureName: String) {


        splitInstallManager.startInstall(singleFeatureInstallRequest(featureName))
            .addOnFailureListener {

                Toast.makeText(
                    applicationContext,
                    "Download failed: ${it.message}",
                    Toast.LENGTH_SHORT
                ).show()

            }

            .addOnSuccessListener {

                Toast.makeText(
                    applicationContext,
                    "Download success feature $featureName success: $it",
                    Toast.LENGTH_SHORT
                ).show()

            }

            .addOnCompleteListener { task ->

                Toast.makeText(
                    applicationContext,
                    "Download complete feature $featureName: ${task.result.toString()}",
                    Toast.LENGTH_SHORT
                ).show()

            }

        var mySessionId = 0

        val listener = SplitInstallStateUpdatedListener {

            mySessionId = it.sessionId()

            when (it.status()) {

                SplitInstallSessionStatus.DOWNLOADING -> {
                    val totalBytes = it.totalBytesToDownload()
                    val progress = it.bytesDownloaded()
                    // Update progress bar.
                }
                SplitInstallSessionStatus.INSTALLING -> Log.d("Status", "INSTALLING")
                SplitInstallSessionStatus.INSTALLED -> Log.d("Status", "INSTALLED")
                SplitInstallSessionStatus.FAILED -> Log.d("Status", "FAILED")
                SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> startIntentSender(
                    it.resolutionIntent().intentSender,
                    null,
                    0,
                    0,
                    0
                )
            }

        }
    }

}