package com.example.lotteryapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tv2 : TextView
    lateinit var lotteryNumber : TextView
    lateinit var shareBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv2 = findViewById(R.id.textView2)
        lotteryNumber = findViewById(R.id.lotteryNumber)
        shareBtn = findViewById(R.id.share)

        val random = generateRandom(6)

        val userName = recieveUserName()

        shareBtn.setOnClickListener(){
            shareResults(userName, random)
        }
        lotteryNumber.text = random
    }

    fun generateRandom(count : Int): String{
        var randomNumbers = List(count){
//            this method below
            (0 .. 42).random()

//            or
//            val random = java.util.Random()
//            val randomNumber = random.nextInt(43)
        }

        return randomNumbers.joinToString(" ")
    }

    fun recieveUserName(): String {
        // retrieve extras that were added to an intent
        val bundle: Bundle? = intent.extras

        return bundle?.getString("username").toString()
    }

    fun shareResults(userName : String, generateNums : String) {

        // Implicit Intents
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$userName generated these numbers.")
        i.putExtra(Intent.EXTRA_TEXT,"The Lottery Numbers are : $generateNums")
        startActivity(i)
    }
}