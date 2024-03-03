package com.example.quiz.client.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.client.GameActivity.ChildrenQUIZ
import com.example.quiz.client.GameActivity.GameActivity
import com.example.quiz.client.GameActivity.LogicQuiz
import com.example.quiz.databinding.FragmentMainMenuBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.UserInformation.text= "User: $param1"


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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainMenuFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainMenuFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}