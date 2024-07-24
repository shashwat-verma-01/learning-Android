package com.example.volumeapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CubeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cube)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result : TextView = findViewById(R.id.cubeResults)
        val editText : EditText = findViewById(R.id.editTextCube)
        val button : Button = findViewById(R.id.CubeBtn)

        button.setOnClickListener(){
            val side = editText.text.toString()
            val s = Integer.parseInt(side)
            val volume = s*s*s
            result.text = "Volume = ${volume.toString()}"
        }
    }
}