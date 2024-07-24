package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val Name : TextView = findViewById(R.id.playerName)
        val resultText : TextView = findViewById(R.id.resultText)
        val btnFinish : Button = findViewById(R.id.btnEnd)

        Name.text = intent.getStringExtra(Constants.User_Name)
        val totalQuestion = intent.getIntExtra(Constants.Total_Questions, 0)
        val correctAnswers = intent.getIntExtra(Constants.Correct_Answers, 0)

        resultText.text = "Your score is $correctAnswers out of $totalQuestion."

        btnFinish.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}