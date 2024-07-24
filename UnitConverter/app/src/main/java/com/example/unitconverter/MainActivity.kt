package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt : EditText = findViewById(R.id.query)
        val btn : Button = findViewById(R.id.btn)
        val res : TextView = findViewById(R.id.result)

        btn.setOnClickListener(){
            var kilo = edt.text.toString().toDouble()
            var pound = kilo * 2.20462
            res.setText(""+pound + " Pounds")
        }
    }
}