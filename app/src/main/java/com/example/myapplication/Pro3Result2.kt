package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result2.*

class Pro3Result2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pro3_result2)

        val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_score1.text="Your Score is $correctAnswers out of $totalQuestions"

        retry.setOnClickListener{
            val intent= Intent(this, Professional3::class.java)
            startActivity(intent)
        }
    }
}