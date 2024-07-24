package com.example.widgetsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt : EditText = findViewById(R.id.edt)
        val btn = findViewById<Button>(R.id.btn)

        btn.setOnClickListener(){
            val text = edt.text

            Toast.makeText(this,"Hello $text", Toast.LENGTH_LONG).show()
        }
    }
}