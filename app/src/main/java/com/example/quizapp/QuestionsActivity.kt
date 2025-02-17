package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuestionsBinding

    private var userName: String? = null
    private var correctAnswers: Int = 0

    private var currentPosition: Int = 1
    private var questionsList: ArrayList<Question>? = null
    private var selectedOptionPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra(Constants.USER_NAME)
        questionsList = Constants.getQuestions()

        setClickListeners()

        setQuestion()
        defaultOptionsView()
    }

    private fun setClickListeners() {
        listOf(
            binding.optionOneTextView,
            binding.optionTwoTextView,
            binding.optionThreeTextView,
            binding.optionFourTextView,
            binding.submitButton
        )
            .forEach { it.setOnClickListener(this) }
    }

    private fun setQuestion() {
        defaultOptionsView()
        enableOptions()
        val question: Question = questionsList!![currentPosition - 1]
        binding.apply {

            questionTextView.text = question.question
            questionImageView.setImageResource(question.image)
            progressBar.progress = currentPosition
            progressTextView.text = "$currentPosition/${progressBar.max}"
            optionOneTextView.text = question.optionOne
            optionTwoTextView.text = question.optionTwo
            optionThreeTextView.text = question.optionThree
            optionFourTextView.text = question.optionFour

            if (currentPosition == questionsList!!.size) {
                submitButton.text = "Finish"
            } else {
                submitButton.text = "Submit"
            }

        }

    }

    private fun defaultOptionsView() {

        val options = listOf(
            binding.optionOneTextView,
            binding.optionTwoTextView,
            binding.optionThreeTextView,
            binding.optionFourTextView
        )

        options.forEach {
            it.setTextColor(Color.parseColor("#7A8089"))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }

    }

    private fun selectedOptionView(textView: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        selectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }

    override fun onClick(view: View?) {

        when (view?.id) {

            R.id.optionOneTextView -> {
                binding.optionOneTextView.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.optionTwoTextView -> {
                binding.optionTwoTextView.let {
                    selectedOptionView(it, 2)
                }
            }

            R.id.optionThreeTextView -> {
                binding.optionThreeTextView.let {
                    selectedOptionView(it, 3)
                }
            }

            R.id.optionFourTextView -> {
                binding.optionFourTextView.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.submitButton -> {
                if (selectedOptionPosition == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionsList!!.size -> {
                            setQuestion()
                        }

                        else -> {
                            Toast.makeText(
                                this@QuestionsActivity,
                                "You made it to the end",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.CORRECT_ANSWER, correctAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    val question = questionsList!![currentPosition - 1]

                    if (question.correctAnswer != selectedOptionPosition) {
                        answerView(selectedOptionPosition, R.drawable.wrong_option_border_bg)
                    } else {
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    disableOptions()

                    if (currentPosition == questionsList!!.size) {
                        binding.submitButton.text = "Finish"
                    } else {
                        binding.submitButton.text = "Next question"
                    }

                    selectedOptionPosition = 0

                }
            }

        }

    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.optionOneTextView.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }

            2 -> {
                binding.optionTwoTextView.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }

            3 -> {
                binding.optionThreeTextView.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }

            4 -> {
                binding.optionFourTextView.background = ContextCompat.getDrawable(
                    this@QuestionsActivity,
                    drawableView
                )
            }


        }
    }

    private fun disableOptions() {
        binding.apply {
            optionOneTextView.isClickable = false
            optionTwoTextView.isClickable = false
            optionThreeTextView.isClickable = false
            optionFourTextView.isClickable = false
        }
    }

    private fun enableOptions() {
        binding.apply {
            optionOneTextView.isClickable = true
            optionTwoTextView.isClickable = true
            optionThreeTextView.isClickable = true
            optionFourTextView.isClickable = true
        }
    }
}