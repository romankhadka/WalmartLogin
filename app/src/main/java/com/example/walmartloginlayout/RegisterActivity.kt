package com.example.walmartloginlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        val firstNameText = findViewById<EditText>(R.id.firstNameText)
        val lastNameText = findViewById<EditText>(R.id.lastNameText)
        val emailText = findViewById<EditText>(R.id.emailText)
        val passwordText = findViewById<EditText>(R.id.passwordText)
        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val email = emailText.text.toString()
            val firstName = firstNameText.text.toString()
            val lastName = lastNameText.text.toString()
            val password = passwordText.text.toString()

            val newUser = User(firstName, lastName, email, password)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user", newUser)
            startActivity(intent)
            Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show()


        }
    }
}
