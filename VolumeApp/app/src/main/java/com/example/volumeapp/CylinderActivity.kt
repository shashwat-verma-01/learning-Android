package com.example.volumeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.PI

class CylinderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cylinder)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val radius : EditText = findViewById(R.id.radiusCyl)
        val height : EditText = findViewById(R.id.heightCyl)
        val result : TextView = findViewById(R.id.resultsCyl)
        val button : Button = findViewById(R.id.btnCyl)

        button.setOnClickListener(){
            val r1 = radius.text.toString()
            val r = Integer.parseInt(r1)
            val h1 = height.text.toString()
            val h = Integer.parseInt(h1)
            val volume = PI*r*r*h
            result.text = "Volume = ${volume.toString()}"
        }

    }
}