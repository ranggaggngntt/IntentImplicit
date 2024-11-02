package com.example.intentimplicit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity


class ShowActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show)

        val imageView: ImageView = findViewById(R.id.image_view)
        val imageUri = intent.getStringExtra("imageUri")

        imageUri?.let {
            imageView.setImageURI(Uri.parse(it))
        }

        val buttonClick = findViewById<Button>(R.id.btn_back)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}