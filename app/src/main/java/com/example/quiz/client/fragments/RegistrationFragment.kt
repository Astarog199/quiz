package com.example.quiz.client.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.MainActivity
import com.example.quiz.R
import com.example.quiz.client.User
import com.example.quiz.databinding.FragmentRegistrationBinding
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date


class RegistrationFragment : Fragment() {

    lateinit var DOB: Date
    private var _binding: FragmentRegistrationBinding? = null
    private val dateFormat = SimpleDateFormat("dd-MM-yy")
    val  calendar = Calendar.getInstance()
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var dob:String

        val buttonNext = binding.buttonNext
        val close = binding.close
        val dateSelection = binding.dateSelection


        buttonNext.setOnClickListener {
            val name = binding.username.text.toString()
            val password = binding.password.text.toString()
            val password2 = binding.password2.text.toString()

            if (name.isNotEmpty() && password.isNotEmpty() && password == password2) {
               User(name, password, DOB).userWrite(requireContext())

                val bundle = Bundle().apply {
                    putString("param1", name)
                    putString("param2", dob)
                }

                parentFragmentManager.commit{
                    replace<MainMenuFragment>(containerViewId = R.id.fragment_container, args = bundle)
                    addToBackStack(MainMenuFragment::class.java.simpleName)
                }
            }else{
                Toast.makeText(this.activity,"Заполните поля", Toast.LENGTH_SHORT).show()
            }
        }

        dateSelection.setOnClickListener {
            val constraints = CalendarConstraints.Builder()
                .setOpenAt(calendar.timeInMillis)
                .build()

            val dateDialog =MaterialDatePicker.Builder.datePicker()
                .setCalendarConstraints(constraints)
                .setTitleText(resources.getString(R.string.select_date_of_birth))
                .build()

            dateDialog.addOnPositiveButtonClickListener { timeInMills ->
                DOB = Date(timeInMills)
                calendar.timeInMillis = timeInMills
                Snackbar.make(binding.dateSelection, dateFormat.format(calendar.time), Snackbar.LENGTH_SHORT).show()
            }
            dob = dateFormat.format(calendar.time)

            dateDialog.show(childFragmentManager, "DatePicker")
        }

        close.setOnClickListener {
            val intent = Intent(this.activity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}