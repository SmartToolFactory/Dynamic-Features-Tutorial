package com.smarttoolfactory.feature1_news

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NewsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        Toast.makeText(this, "News Feature is started", Toast.LENGTH_SHORT).show()
    }
}