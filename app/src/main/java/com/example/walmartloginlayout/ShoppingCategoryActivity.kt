package com.example.walmartloginlayout

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShoppingCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)

        val username = intent.getStringExtra("username")

        val welcomeMessage = "Welcome, $username"
        val welcomeTextView = findViewById<TextView>(R.id.welcomeTextView)
        welcomeTextView.text = welcomeMessage

        val clothingImage = findViewById<ImageView>(R.id.clothingImage)

        clothingImage.setOnClickListener {
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_SHORT).show()
        }

        val electronicsImage = findViewById<ImageView>(R.id.electronicsImage)

        electronicsImage.setOnClickListener {
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_SHORT).show()
        }

        val beautyImage = findViewById<ImageView>(R.id.beautyImage)

        clothingImage.setOnClickListener {
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_SHORT).show()
        }

        val foodImage = findViewById<ImageView>(R.id.foodImage)

        foodImage.setOnClickListener {
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_SHORT).show()
        }

    }
}
