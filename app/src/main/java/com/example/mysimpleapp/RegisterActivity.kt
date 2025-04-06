package com.example.mysimpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.mysimpleapp.model.User

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etName = findViewById<EditText>(R.id.etNameRegister)
        val etEmail = findViewById<EditText>(R.id.etEmailRegister)
        val etPassword = findViewById<EditText>(R.id.etPasswordRegister)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (name.isBlank() || email.isBlank() || password.isBlank() || !email.contains("@")) {
                Toast.makeText(this, "Complete the data properly", Toast.LENGTH_SHORT).show()
            } else {
                val user = User(name, email, password)
                val intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }
        }
    }
}
