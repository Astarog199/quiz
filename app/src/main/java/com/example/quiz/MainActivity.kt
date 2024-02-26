package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.quiz.client.fragments.BlankFragment
import com.example.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val buttonAuthorization = binding.buttonAuthorization
//        val buttonRegistration = binding.buttonRegistration

//        buttonAuthorization.setOnClickListener{
//            val intent = Intent(this, AuthorizationActivity::class.java)
//            startActivity(intent)
//        }
//
//        buttonRegistration.setOnClickListener{
//            val intent = Intent(this, regStepOne::class.java)
//            startActivity(intent)
//        }



        supportFragmentManager.commit {
            replace<BlankFragment>(R.id.fragment_container)
            addToBackStack(BlankFragment::class.java.simpleName)
        }
    }
}