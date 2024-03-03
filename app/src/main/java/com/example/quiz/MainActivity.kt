package com.example.quiz

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.ImageView
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.client.fragments.BlankFragment
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val rotationX = PropertyValuesHolder.ofFloat(View.ROTATION_X, 0f, 360f)
    private val transitionY = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -150f, 440f)
    private val transitionYstep2 = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, -150f, 150f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val logo =binding.logo
        val firstAnimation1 = ObjectAnimator.ofPropertyValuesHolder(logo, transitionY).apply {
            duration = 2500
            interpolator = AccelerateInterpolator()
            repeatCount = 1
            repeatMode = ObjectAnimator.REVERSE
        }
        val firstAnimation2 = ObjectAnimator.ofPropertyValuesHolder(logo, transitionYstep2).apply {
            duration = 5000
            interpolator = AccelerateInterpolator()
//            repeatMode = ObjectAnimator.REVERSE
        }
        val secondAnimation = ObjectAnimator.ofPropertyValuesHolder(logo, rotationX).apply {
            duration = 1000
            interpolator = AccelerateInterpolator()
        }

        with(window){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                enterTransition = Slide(Gravity.LEFT)
                exitTransition = Slide(Gravity.RIGHT)
            //            enterTransition = Explode()
            //            exitTransition = Explode()
            }
        }

//        animationV2(firstAnimation1,firstAnimation2, secondAnimation)
        (AnimatorInflater.loadAnimator(this, R.animator.animation_logo) as AnimatorSet).apply {
            setTarget(logo)
            start()
        }
        supportFragmentManager.commit {
            replace<BlankFragment>(R.id.fragment_container)
            addToBackStack(BlankFragment::class.java.simpleName)
        }
    }

    private fun animationV2(
        firstAnimation: ObjectAnimator,
        firstAnimation2: ObjectAnimator,
        secondAnimation: ObjectAnimator, ) {
        AnimatorSet().apply {
            play(firstAnimation2).after(firstAnimation).with(secondAnimation)
            start()
        }
    }

}