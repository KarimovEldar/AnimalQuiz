package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)

        binding.scoreTextView.text = "Your score is $correctAnswers out of $totalQuestions"
        binding.nameTextView.text = intent.getStringExtra(Constants.USER_NAME)
        binding.finishButton.setOnClickListener{
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
            finish()
        }


    }
}