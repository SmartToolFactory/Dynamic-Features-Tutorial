package com.smarttoolfactory.tutorial1_1basics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.buttonNews).setOnClickListener {

            val intent = Intent()
                .setClassName(this, "com.smarttoolfactory.feature1_news.NewsActivity")
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {

            val intent = Intent()
                .setClassName(this, "com.smarttoolfactory.feature1_login.LoginActivity")
            startActivity(intent)
        }

        findViewById<Button>(R.id.buttonGallery).setOnClickListener {

            val intent = Intent()
                .setClassName(this, "com.smarttoolfactory.feature1_gallery.GalleryActivity")
            startActivity(intent)
        }


        // Get fragment name from feature1_news module
        val fragmentClassName = "com.smarttoolfactory.feature1_news.NewsFragment"
        val fragmentClazz = classLoader.loadClass(fragmentClassName)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragmentClazz.newInstance() as Fragment)
            .commitNow()
    }
}