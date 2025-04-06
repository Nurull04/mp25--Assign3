package com.example.mysimpleapp

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mysimpleapp.model.User

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val tvWelcome = findViewById<TextView>(R.id.tvWelcomeMessage)
        val user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("user", User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<User>("user")
        }

        user?.let {
            val welcomeMessage = getString(R.string.welcome_message, it.name)
            tvWelcome.text = welcomeMessage
        }
    }
}
