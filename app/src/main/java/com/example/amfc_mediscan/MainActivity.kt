package com.example.amfc_mediscan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var upload: Button
    lateinit var pick: Button

    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        Glide.with(this)
            .load(uri)
            .into(imageView)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        upload = findViewById(R.id.upload)

        pick = findViewById(R.id.pick)
        pick.setOnClickListener {
            getContent.launch("image/*")
        }

        upload.setOnClickListener {

            val intent = Intent(this, DisplayActivity::class.java)
            startActivity(intent)
        }
    }
}