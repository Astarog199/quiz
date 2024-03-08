package com.example.quiz.client

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.transition.Slide
import android.view.Gravity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.R
import com.example.quiz.client.fragments.BlankFragment
import com.example.quiz.client.fragments.MainMenuFragment
import com.example.quiz.databinding.ActivityMainMenuBinding
import java.io.FileOutputStream
import java.io.IOException

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(window){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                enterTransition = Slide(Gravity.LEFT)
                exitTransition = Slide(Gravity.RIGHT)
            //  enterTransition = Explode()
            //  exitTransition = Explode()
            }


        }

        supportFragmentManager.commit {
            replace<MainMenuFragment>(R.id.fragment_main_menu)
            addToBackStack(MainMenuFragment::class.java.simpleName)
        }
    }
}