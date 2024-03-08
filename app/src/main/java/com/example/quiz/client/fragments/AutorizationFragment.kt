package com.example.quiz.client.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.R
import com.example.quiz.Storage.Repository
import com.example.quiz.databinding.FragmentAutorizationBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AutorizationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AutorizationFragment : Fragment() {


    private var _binding: FragmentAutorizationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutorizationBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener {
            val name = binding.name.text.toString()
            val password = binding.password.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty()){
              autorization(name, password)
            }
        }

        val text = binding.text2.text
        val spannableString = SpannableStringBuilder(text)
        spannableString.setSpan(ForegroundColorSpan(Color.BLUE), text.length - 8, text.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.text2.text= spannableString
    }

    /**
     * метод авторизации
     * если autorization == true создаётся экземпляр класса user ипользователь переходит в MainMenuActivity
     * если autorization == false то пользователь видит сообщение "Пользователь не найден"
     */
    private fun autorization(name: String, password: String) {
        val repository = Repository()
        val res = repository.autorization(requireContext(), name, password)
        if (res){
            parentFragmentManager.commit {
                replace<MainMenuFragment>(R.id.fragment_container)
                addToBackStack(MainMenuFragment::class.simpleName)
            }
        }else{
            Toast.makeText(this.activity, "Пользователь не найден", Toast.LENGTH_SHORT).show()
        }
    }
}