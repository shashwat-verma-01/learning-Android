package com.example.planetsapp

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val listView : ListView = findViewById(R.id.listView)

        val planet1 = Planets("Mercury", "0 Moons", R.drawable.mercury)
        val planet2 = Planets("Venus", "0 Moons", R.drawable.venus)
        val planet3 = Planets("Earth", "1 Moon", R.drawable.earth)
        val planet4 = Planets("Mars", "2 Moons", R.drawable.mars)
        val planet5 = Planets("Jupiter", "67 Moons", R.drawable.jupiter)
        val planet6 = Planets("Saturn", "62 Moons", R.drawable.saturn)
        val planet7 = Planets("Uranus", "27 Moons", R.drawable.uranus)
        val planet8 = Planets("Neptune", "13 Moons", R.drawable.neptune)

        var planetList = ArrayList<Planets>()
        planetList.add(planet1)
        planetList.add(planet2)
        planetList.add(planet3)
        planetList.add(planet4)
        planetList.add(planet5)
        planetList.add(planet6)
        planetList.add(planet7)
        planetList.add(planet8)

        var adapter = CustomAdapter(this,
            planetList)

        listView.adapter = adapter
    }
}