package com.example.quiz.client.GameActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.client.MainMenuActivity
import com.example.quiz.client.fragments.BlankFragment
import com.example.quiz.client.fragments.MainMenuFragment
import com.example.quiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result = intent?.getStringExtra("res")
        val result2 = intent?.getStringExtra("res2")

        binding.resCorrect.text =result
        binding.resWrong.text =result2

        binding.buttonFinish.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }
    }
}