package com.example.lotteryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var title : TextView
    lateinit var editText: EditText
    lateinit var generate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.textView)
        editText = findViewById(R.id.editTextName)
        generate = findViewById(R.id.GenerateBtn)

        generate.setOnClickListener(){
            var name: String  = editText.toString()

            var i = Intent(this,SecondActivity::class.java)

            i.putExtra("username", name)
            startActivity(i)
        }
    }
}