package com.example.worldcupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1 - Adapter View : ListView
        var listView = findViewById<ListView>(R.id.listView)

        // 2 - Adapter
        var adapter = MyAdapter(this, generateData())

        listView?.adapter = adapter
        adapter?.notifyDataSetChanged()
    }

    // 3 - Data Source
    fun generateData() : ArrayList<CountryModelClass>{
        var result = ArrayList<CountryModelClass>()

        var country1 : CountryModelClass = CountryModelClass(
            "Brazil",
            "5",
            R.drawable.brazil
        )
        var country2 : CountryModelClass = CountryModelClass(
            "France",
            "4",
            R.drawable.france
        )
        var country3 : CountryModelClass = CountryModelClass(
            "Germany",
            "3",
            R.drawable.germany
        )
        var country4 : CountryModelClass = CountryModelClass(
            "India",
            "10",
            R.drawable.india
        )
        var country5 : CountryModelClass = CountryModelClass(
            "Saudi Arabia",
            "2",
            R.drawable.saudiarabia
        )
        var country6 : CountryModelClass = CountryModelClass(
            "Spain",
            "2",
            R.drawable.spain
        )
        var country7 : CountryModelClass = CountryModelClass(
            "United Kingdom",
            "3",
            R.drawable.unitedkingdom
        )
        var country8 : CountryModelClass = CountryModelClass(
            "United States of America",
            "4",
            R.drawable.usa
        )

        result.add(country1)
        result.add(country2)
        result.add(country3)
        result.add(country4)
        result.add(country5)
        result.add(country6)
        result.add(country7)
        result.add(country8)

        return result
    }

}