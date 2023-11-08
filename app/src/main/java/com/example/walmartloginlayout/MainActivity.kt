package com.example.walmartloginlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val userList = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userList.add(User("Roman", "Khadka", "user1@email.com", "password1"))
        userList.add(User("Test", "User", "user2@email.com", "password2"))
        userList.add(User("Test", "User","user3@email.com", "password3"))
        userList.add(User("Test", "User","user4@email.com", "password4"))
        userList.add(User("Test", "User","user5@email.com", "password5"))

        if(intent.getSerializableExtra("user") != null) {
            userList.add(intent.getSerializableExtra("user") as User)
        }

        val signInButton = findViewById<Button>(R.id.signInButton)
        val forgotPasswordBtn = findViewById<TextView>(R.id.forgotPasswordBtn)

        signInButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            val user = userList.find { it.username == username && it.password == password }

            if (user != null) {
                val intent = Intent(this, ShoppingCategoryActivity::class.java)
                intent.putExtra("username", username)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        forgotPasswordBtn.setOnClickListener {
            val username = findViewById<EditText>(R.id.emailEditText).text.toString()
            val user = userList.find { it.username == username }

            val subject = "Password Reset"
            val message = "Your password is: ${user?.password}"
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(username))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, message)

            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            } else {
                Toast.makeText(this, "No Email Application Found", Toast.LENGTH_SHORT).show()
            }
        }

        val createAccountBtn = findViewById<Button>(R.id.createAccountBtn)

        createAccountBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}