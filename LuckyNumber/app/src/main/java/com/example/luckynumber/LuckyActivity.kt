package com.example.luckynumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class LuckyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lucky)

        val txt :  TextView = findViewById(R.id.txt2)
        val txt2 : TextView = findViewById(R.id.luckyText)
        val btnS : Button = findViewById(R.id.shareBtn)

        var username = recieveUsrnm()

        var randNum = genRandom()
//        Toast.makeText(this, ""+randNum ,Toast.LENGTH_LONG).show()
        txt2.text = randNum.toString()

        btnS.setOnClickListener(){
            shareData(username, randNum)
        }
    }
    fun recieveUsrnm() : String {
        var bundle : Bundle ?= intent.extras
        var username = bundle?.getCharSequence("name").toString()
        return username
    }

    fun genRandom() : Int{
        val random = Random.nextInt(1000)
        return random
    }

    fun shareData(username : String, num : Int){
        var i = Intent(Intent.ACTION_SEND)
        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        i.putExtra(Intent.EXTRA_TEXT, "The lucky number is $num")
        startActivity(i)
    }
}