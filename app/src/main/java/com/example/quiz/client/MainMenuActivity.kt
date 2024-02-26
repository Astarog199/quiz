package com.example.quiz.client

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.R
import com.example.quiz.client.fragments.BlankFragment
import com.example.quiz.client.fragments.MainMenuFragment
import com.example.quiz.databinding.ActivityMainMenuBinding

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            replace<MainMenuFragment>(R.id.fragment_main_menu)
            addToBackStack(MainMenuFragment::class.java.simpleName)
        }
    }
}