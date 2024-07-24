package com.example.externalintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn : Button = findViewById(R.id.btn)

        btn.setOnClickListener(){
            var intent : Intent = Intent(this, Activity2::class.java)

            //Passing data between activities
            intent.putExtra("age",30)

            startActivity(intent)
        }
    }
}