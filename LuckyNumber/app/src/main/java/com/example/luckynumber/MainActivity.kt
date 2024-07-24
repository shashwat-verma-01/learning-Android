package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val b1 : Button = findViewById(R.id.btn1)
        val txt : TextView = findViewById(R.id.txt1)
        val edt : EditText = findViewById(R.id.edt1)

        b1.setOnClickListener(){
            var username = edt.text

            var i : Intent = Intent(this, LuckyActivity::class.java)
            i.putExtra("name" , username)

            startActivity(i)
        }
    }
}