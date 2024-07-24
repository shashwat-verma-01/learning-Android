package com.example.fragmentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btn1 : Button = findViewById(R.id.displayFrag1)
        val btn2 : Button = findViewById(R.id.displayFrag2)
        val frameLayout : FrameLayout = findViewById(R.id.frameLayout)

        btn1.setOnClickListener(){
            val fragment1 : FragmentOne = FragmentOne()
            loadFragment(fragment1)
        }
        btn2.setOnClickListener(){
            val fragment2 : FragmentTwo = FragmentTwo()
            loadFragment(fragment2)
        }
    }

    fun loadFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager

//        Fragment Transaction : Used to define a set of operations
//        to be performed on fragments.

        val fragmentTransaction : FragmentTransaction =
            fragmentManager.beginTransaction()

//        Replacing the frameLayout with new fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()

    }

}