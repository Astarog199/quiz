package com.example.quiz.client.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quiz.MainActivity
import com.example.quiz.Storage.Repository
import com.example.quiz.client.GameActivity.ChildrenQUIZ
import com.example.quiz.client.GameActivity.GameActivity
import com.example.quiz.client.GameActivity.LogicQuiz
import com.example.quiz.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {


    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentMainMenuBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.show.setOnClickListener {
            val text = Repository()
                .readUserDB(this.requireActivity())
            binding.UserInformation.text = text.toString()
        }

        binding.close.setOnClickListener {
            val intent = Intent(this.activity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  ChildrenQUIZ(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent)
        }
        binding.button2.setOnClickListener {

            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent)
        }
        binding.button3.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button4.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button5.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button6.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button7.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button8.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button9.setOnClickListener {             val checkAnswear = intArrayOf(10)
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent) }

        binding.button10.setOnClickListener {
            val answear = mutableMapOf<Number, List<String>>()
            val quiz =  LogicQuiz(answear)

            val intent = Intent(this.activity, GameActivity::class.java)
            intent.putExtra("key", quiz)
            startActivity(intent)
        }
    }
}