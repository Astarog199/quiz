package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.databinding.ActivityRegStepOneBinding

class regStepOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegStepOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val butForReg = binding.buttonNext
        val userName = binding.username
        val userEmail = binding.Email

        butForReg.setOnClickListener{
            val name = userName.text
            val email = userEmail.text
            if (name!!.isNotBlank()  && email!!.isNotBlank()){
                Toast.makeText(this,"$name $email", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, regStepTwo::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
//                val intent = Intent(this, regStepTwo::class.java)
//                startActivity(intent)
            }
        }
    }
}