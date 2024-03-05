package com.example.quiz.client.GameActivity

import android.animation.AnimatorInflater
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.R
import com.example.quiz.client.MainMenuActivity
import com.example.quiz.databinding.ActivityResultBinding
import kotlin.concurrent.thread


class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonFinish = binding.buttonFinish
        val title = binding.title

        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        val resultCorrectAnswear = intent?.getStringExtra("res")
        val resultWrongAnswear = intent?.getStringExtra("res2")

//        binding.resCorrect.text = result
//        binding.pWrongAnswers.text = result2

        val countCorrectAnswear = resources.getQuantityString(R.plurals.number_of_correct_answers, resultCorrectAnswear!!.toInt(), resultCorrectAnswear.toInt())
        binding.pCorrectAnswers.text = countCorrectAnswear

        val countWrongAnswear = resources.getQuantityString(R.plurals.number_of_wrong_answers, resultWrongAnswear!!.toInt(), resultWrongAnswear.toInt())
        binding.pWrongAnswers.text = countWrongAnswear

        animationButton(buttonFinish)
        animationTitile(title)
    }

    fun animationButton(buttonFinish: Button) {
        buttonFinish.translationY = 150f
        buttonFinish.alpha = 0f

        buttonFinish.animate().apply {
            duration = 1500
            translationY(-150f)
            alpha(1f)
        }.start()
    }

    fun animationTitile(title: TextView) {
        title.animate().apply {
            duration = 5000
            rotation(360f)
        }

        (AnimatorInflater.loadAnimator(this, R.animator.custom_animation) as ObjectAnimator)
            .apply {
                target = title
                start()
            }
    }
}