package com.example.volumeapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomAdapter (context : Context, private val gridItems : List<Shapes>)
    : ArrayAdapter<Shapes>(context, 0, gridItems){

//        context : required to access resources and layouts
//        0 : the resource ID for the layout file, 0 because we need to
//              inflate our custom layout, and not a predefined layout
//        gridItems : lists of Shapes items that the adapter will adapt
//              and display in the gridView

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemView = convertView
        val holder : ViewHolder

        if(itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)
            holder = ViewHolder()
            holder.imageView = itemView.findViewById(R.id.imageView)
            holder.textView = itemView.findViewById(R.id.textView)

//            Associating the ViewHolder Object with the Created View
//            avoiding the need to create a new "ViewHolder" everytime
            itemView.tag = holder
        }else{
            holder = itemView.tag as ViewHolder
        }

        val currentItem = gridItems[position]
        holder.imageView.setImageResource(currentItem.shapeImg)
        holder.textView.text = currentItem.shapeName

//        !! : Non-null assertion Operator
        return itemView!!
    }

        private class ViewHolder{

//            a design pattern used to improve the performance of
//            ListView, GridView, RecyclerView and others by caching views
//            for smoother scrolling
//            It serves as a container for the views of a single item in
//            the Gridview, reducing the number of calls to "findViewById()".

            lateinit var imageView : ImageView
            lateinit var textView : TextView

        }
}