package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonAuthorization = binding.buttonAuthorization
        val buttonRegistration = binding.buttonRegistration

        buttonAuthorization.setOnClickListener{
            val intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }

        buttonRegistration.setOnClickListener{
            val intent = Intent(this, regStepOne::class.java)
            startActivity(intent)
        }
    }
}