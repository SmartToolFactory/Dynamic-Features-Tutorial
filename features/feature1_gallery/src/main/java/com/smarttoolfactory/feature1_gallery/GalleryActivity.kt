package com.smarttoolfactory.feature1_gallery

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        Toast.makeText(this, "Gallery Feature is started", Toast.LENGTH_SHORT).show()

    }
}