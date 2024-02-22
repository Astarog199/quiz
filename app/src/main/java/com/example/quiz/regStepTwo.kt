package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityRegStepTwoBinding

class regStepTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegStepTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegistration.setOnClickListener{
            save()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.buttonBack.setOnClickListener{
            finish()
        }
    }

    private fun save(){
        Toast.makeText(this, "Create new User", Toast.LENGTH_SHORT).show()
    }
}