package com.example.externalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

//        Rcieving data from first activity
        var bundle : Bundle? = intent.extras
        var age = bundle?.getInt("age")
        Toast.makeText(this, "The passed age is $age", Toast.LENGTH_LONG).show()

    }
}