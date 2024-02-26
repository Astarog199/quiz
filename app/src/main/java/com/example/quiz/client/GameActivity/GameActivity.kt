package com.example.quiz.client.GameActivity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.quiz.databinding.ActivityGameBinding


private var FLAG = false
private var numberAnswear = 0
var checkAnswear = mutableListOf(10)
var result = 0

class GameActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val quiz: QUIZ = intent.getParcelableExtra("key")!!
        val answear = quiz.answear

        val radioGroup = binding.options
        val button = binding.buttonAnswer

        checkAnswear.fill(0)



        getOptionElement(answear, numberAnswear, binding)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.option1.id -> checkAnswer(getTextAnswear(1, answear), answear.get(numberAnswear))
                binding.option2.id -> checkAnswer(getTextAnswear(2, answear), answear.get(numberAnswear))
                binding.option3.id -> checkAnswer(getTextAnswear(3, answear), answear.get(numberAnswear))
                binding.option4.id -> checkAnswer(getTextAnswear(4, answear), answear.get(numberAnswear))
            }
            button.setOnClickListener {
                setCheckAnswear()
                showText()
                if (numberAnswear != 9){
                    numberAnswear++
                    getOptionElement(answear, numberAnswear, binding)
                }else{
//                    val res = quiz.getResult()
                    val intent = Intent(this, ResultActivity::class.java)
                    numberAnswear=0
                    intent.putExtra("res", result.toString())
                    intent.putExtra("res2", (10- result).toString())
                    startActivity(intent)
                }
            }
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
            Toast.makeText(this,"Правильный ответ $result", Toast.LENGTH_SHORT).show()
        } else{
            Toast.makeText(this,"Неравильный ответ $result", Toast.LENGTH_SHORT).show()
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
        for (i in checkAnswear) {
            if (checkAnswear[i] == 1) res++
        }
        return res
    }

    fun setCheckAnswear() {
        if (FLAG) result++
//        if (FLAG) checkAnswear[numberAnswear] = 1
    }
}