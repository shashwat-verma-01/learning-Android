package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etText : EditText = findViewById(R.id.etText)
        val btnStart : Button = findViewById(R.id.btnStart)
        btnStart.setOnClickListener(){
            if (etText.text.isEmpty()){
                Toast.makeText(this, "Please Enter Name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity :: class.java)
                intent.putExtra(Constants.User_Name, etText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}