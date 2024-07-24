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

class SphereActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sphere)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result: TextView = findViewById(R.id.textViewSphere2)
        val editText : EditText = findViewById(R.id.editTextSphere)
        val button : Button = findViewById(R.id.sphereBtn)

        button.setOnClickListener(){
            val radius = editText.text.toString()
            var r = Integer.parseInt(radius)
            var volume = (4/3) * PI * r*r*r
            result.text = "V = ${volume.toString()}"
        }

    }
}