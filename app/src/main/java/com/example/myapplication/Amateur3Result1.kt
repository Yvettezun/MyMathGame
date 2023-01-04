package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_amateur3_result1.*
import kotlinx.android.synthetic.main.activity_result.*
import kotlinx.android.synthetic.main.activity_result.next_level
import kotlinx.android.synthetic.main.activity_result.tv_score

class Amateur3Result1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amateur3_result1)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_score.text = "Your Score is $correctAnswers out of $totalQuestions"

        next_level.setOnClickListener {
            startActivity(Intent(this, SemiPro::class.java))
            finish()
        }

        main_menu.setOnClickListener{
            startActivity(Intent(this, MainPage::class.java))
            finish()
        }
    }
}