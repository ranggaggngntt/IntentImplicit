package com.example.intentimplicit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.Button

class MainActivity : ComponentActivity() {

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            // Start ShowActivity and pass the URI as an extra
            val showIntent = Intent(this, ShowActivity::class.java).apply {
                putExtra("imageUri", it.toString())
            }
            startActivity(showIntent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonChooseImage: Button = findViewById(R.id.button_choose_image)
        buttonChooseImage.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        pickImageLauncher.launch("image/*")
    }
}
