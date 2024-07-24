package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1 - Adapter View: ListView
        var listView : ListView = findViewById(R.id.listView)

        // 2 - Define data source
        val world_cup_array = arrayOf(
            "India", "Australia", "England", "Pakistan", "West Indies"
        )

        // 3 - Adapter
        val arrayAdapter : ArrayAdapter<*>

        arrayAdapter = ArrayAdapter(
            this,
            R.layout.list_item,
            R.id.textView,
            world_cup_array
        )

        // 4 - connect listview to adapter

        listView.adapter = arrayAdapter
    }
}