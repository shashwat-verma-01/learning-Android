package com.example.planetsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

// Commonly used types of adapters:-
// 1 - BaseAdapter : parent for all other adapters
// 2 - ArrayAdapter : used whenever a list of single items is there backed ny an array
// 3 - Custom ArrayAdapter : used whenever we need to display a custom list
// 4 - SimpleAdapter : easy adapter to map static data to views defined in XML file
// 5 - Custom SimpleAdapter : used whenever we need tp display a customised list and need to access
//                              the child items of the list or grid

class CustomAdapter(val context : Context, val planets : List<Planets>) :  BaseAdapter(){
    override fun getCount(): Int {
        return planets.size
    }

    override fun getItem(position: Int): Any {
        return planets[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater

        val view : View
        if (convertView == null){
            view = inflater.inflate(R.layout.planet_list_item,
                parent,
                false)
        } else{
            view = convertView
        }

        val item = getItem(position) as Planets

        val title = view.findViewById<TextView>(R.id.PlanetName)
        val moonCount = view.findViewById<TextView>(R.id.moonCount)
        val imagePlanet = view.findViewById<ImageView>(R.id.imageView)

        title.text = item.title
        moonCount.text = item.moonCount
        imagePlanet.setImageResource(item.imagePlanet)

        view.setOnClickListener(){
            Toast.makeText(context,
                "You clicked ${planets[position].title}.\nIt has ${planets[position].moonCount}.",
                Toast.LENGTH_SHORT).show()
        }

        return view
    }
}