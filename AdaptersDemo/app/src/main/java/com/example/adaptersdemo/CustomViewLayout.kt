package com.example.adaptersdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CustomViewLayout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_view_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView : ListView = findViewById(R.id.customList)

//        2 - Create a data source
//        The underlying set of data that  "ListView" displays
        val operatingSystems = listOf(
            "Windows", "Linux", "Android", "iOS", "MacOS", "iPadOS", "WearOS"
        )

//        3 - Adapter
//        The ListView doesn't directly hold the data it displays.
//        It relies on the adapter to populate the data.
//        The adapter is responsible for creating views for each item in the data source
//        and binding data to those views
       val adapter : CustomAdapter = CustomAdapter(this, operatingSystems)

//        4 - Set the adapter to the ListView
        listView.adapter = adapter
    }
}