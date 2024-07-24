package com.example.adaptersdemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(private val context : Context,
                    private val items : List<String>) : BaseAdapter() {
    override fun getCount(): Int {
//        returns the number of items in the data set
        return items.size

    }

    override fun getItem(position: Int): Any {
//        Returns the data item at the specified position in the data set
        return items[position]
    }

    override fun getItemId(position: Int): Long {
//        Returns a unique identifier for the item at the specified position
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//        Returns a view that displays the data at the specified position in the data set
//        convertView : recycled view that can be reused to optimize performance
        val inflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view : View
        if (convertView == null){
//            inflate a new view using layout inflater
            view = inflater.inflate(
                R.layout.cutom_layout,
                parent,
                false
            )
        }else{
            view = convertView
        }

        val item = getItem(position) as String
        val titleTextView : TextView = view.findViewById(R.id.textView1)

        titleTextView.text = item

        return view
    }
}