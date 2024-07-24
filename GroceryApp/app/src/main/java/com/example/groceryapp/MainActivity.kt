package com.example.groceryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView : RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)

        var groceryItems : ArrayList<ItemModel> = ArrayList()
        val v1 = ItemModel("Fruits", "Fresh Fruits from the Garden.", R.drawable.fruit)
        val v2 = ItemModel("Vegetables", "Delicious Fresh Vegetables.", R.drawable.vegitables)
        val v3 = ItemModel("Bakery", "Bread, Wheat and Grains.", R.drawable.bread)
        val v4 = ItemModel("Beverages", "Juice, Tea, Coffee and Soda.", R.drawable.beverage)
        val v5 = ItemModel("Dairy", "Milk, Shakes, Yogurt and other Dairy Products.", R.drawable.milk)
        val v6 = ItemModel("Snacks", "Popcorn, Donuts and other Snacks.", R.drawable.popcorn)

        groceryItems.add(v1)
        groceryItems.add(v2)
        groceryItems.add(v3)
        groceryItems.add(v4)
        groceryItems.add(v5)
        groceryItems.add(v6)

        val adapter = RecyclerAdapter(groceryItems)
        recyclerView.adapter = adapter
    }
}