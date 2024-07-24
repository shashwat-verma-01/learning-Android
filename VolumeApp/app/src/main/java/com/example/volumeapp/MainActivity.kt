package com.example.volumeapp

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
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

//        The view
        val gridView : GridView = findViewById(R.id.gridView)

//        The data source
        var shape1 : Shapes = Shapes(R.drawable.sphere, "Sphere",)
        var shape2 : Shapes = Shapes(R.drawable.cube, "Cube",)
        var shape3 : Shapes = Shapes(R.drawable.cylinder, "Cylinder",)
        var shape4 : Shapes = Shapes(R.drawable.cuboid, "Cuboid",)

        val gridItems = listOf<Shapes>(shape1, shape2, shape3, shape4)

//        The adapter
        val customAdapter = CustomAdapter(this, gridItems)
        gridView.adapter = customAdapter

        gridView.setOnItemClickListener { parent, view, position, id ->
            val clickItem = customAdapter.getItem(position)

            if(clickItem?.shapeName.equals("Sphere")){
                val i = Intent(this, SphereActivity::class.java)
                startActivity(i)
            }
            else if(clickItem?.shapeName.equals("Cube")){
                val i = Intent(this, CubeActivity::class.java)
                startActivity(i)
            }
            else if(clickItem?.shapeName.equals("Cylinder")){
                val i = Intent(this, CylinderActivity::class.java)
                startActivity(i)
            }
            else if(clickItem?.shapeName.equals("Cuboid")){
                val i = Intent(this, CuboidActivity::class.java)
            }

        }

    }
}