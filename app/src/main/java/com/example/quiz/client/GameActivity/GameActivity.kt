package com.example.quiz.client.GameActivity

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.client.MainMenuActivity
import com.example.quiz.databinding.ActivityGameBinding
import java.util.ArrayList


private var FLAG = false
private var numberAnswear = 0
private lateinit var quiz: QUIZ
private var size: Int = 0
private var valueAnswear: MutableList<Int> = mutableListOf()

class GameActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGameBinding.inflate(layoutInflater)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)
        setContentView(binding.root)
        valueAnswear = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
        quiz = intent.getParcelableExtra("key")!!
        val answear = quiz.answear
        size = answear.size-1

        val radioGroup = binding.options
        val button = binding.buttonAnswer


        binding.close.setOnClickListener {
            val intent = Intent(this, MainMenuActivity::class.java)
            startActivity(intent)
        }

        getOptionElement(answear, numberAnswear, binding)

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.option1.id -> checkAnswer(getTextAnswear(1, answear), answear.get(numberAnswear))
                binding.option2.id -> checkAnswer(getTextAnswear(2, answear), answear.get(numberAnswear))
                binding.option3.id -> checkAnswer(getTextAnswear(3, answear), answear.get(numberAnswear))
                binding.option4.id -> checkAnswer(getTextAnswear(4, answear), answear.get(numberAnswear))
            }
            button.setOnClickListener {

                if (radioGroup.checkedRadioButtonId != -1) {
                    setCheckAnswear()
                    showText()
                    next(binding, radioGroup, options)
                }
            }
        }


        animateAnswear(radioGroup)
    }

    private fun animateAnswear(radioGroup: RadioGroup) {
        radioGroup.alpha = 0f
        radioGroup.animate().apply {
            duration = 5000
            alpha(1f)
        }
    }

    private fun checkAnswer(answear: String, answears: List<String?>?) {
        FLAG = if (answears?.get(5) == answear) {
            true
        }else{
            false
        }
    }

    private fun showText() {
        if (FLAG){
            Toast.makeText(this,"Правильный ответ", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(this,"Неравильный ответ", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getOptionElement(
        answear: Map<Number, List<String>>,
        numberAnswear: Int,
        binding: ActivityGameBinding
    ) {
        binding.textTitle.text = answear.get(numberAnswear)!!.get(index = 0)
        binding.option1.text = getTextAnswear(1, answear)
        binding.option2.text = getTextAnswear(2, answear)
        binding.option3.text = getTextAnswear(3, answear)
        binding.option4.text = getTextAnswear(4, answear)
    }

    private fun getTextAnswear(int: Int, answear: Map<Number, List<String>>) : String {
       return answear.get(numberAnswear)!!.get(index = int)
    }

    fun getResult(): Int {
        var res = 0
        for (i in valueAnswear) {
            if (i == 1) res++
        }
        return res
    }

    fun setCheckAnswear() {
        if (FLAG) valueAnswear[numberAnswear] = 1
    }

    /**
     * Логика кнопки "next"
     * если
     */
    fun next(
        binding: ActivityGameBinding,
        radioGroup: RadioGroup,
        options: ActivityOptions
    ) {
        if (numberAnswear != size) {
            numberAnswear++
            getOptionElement(quiz.answear, numberAnswear, binding)
            radioGroup.clearCheck()
            animateAnswear(radioGroup)
        } else {
            val res = getResult()
            val intent = Intent(this, ResultActivity::class.java)
            numberAnswear = 0
            intent.putExtra("res", res.toString())
            intent.putExtra("res2", (10 - res).toString())
            startActivity(intent, options.toBundle())
        }
    }
}