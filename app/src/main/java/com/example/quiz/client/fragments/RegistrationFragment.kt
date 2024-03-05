package com.example.quiz.client.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentRegistrationBinding? = null
    private val dateFormat = SimpleDateFormat("dd-MM-yy")
    val  calendar = Calendar.getInstance()
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

            val bundle = Bundle().apply {
                putString("param1", name)
                putString("param2", dob)
            }

            if (name.isNotEmpty() && password.isNotEmpty() && password == password2) {
               User(name, password)

                parentFragmentManager.commit{
                    replace<MainMenuFragment>(containerViewId = R.id.fragment_container, args = bundle)
                    addToBackStack(MainMenuFragment::class.java.simpleName)
                }
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegistrationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegistrationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}