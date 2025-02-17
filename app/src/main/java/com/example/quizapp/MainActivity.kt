  package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

  class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            if(binding.nameEditText.text.toString().isNotEmpty()){

                val intent = Intent(this,QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME,binding.nameEditText.text.toString())
                startActivity(intent)
                finish()

            }else{
                Toast.makeText(this,"Please enter your name!",Toast.LENGTH_LONG).show()
            }
        }

    }
}

