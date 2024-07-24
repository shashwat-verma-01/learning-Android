package com.example.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val itemsList : ArrayList<ItemModel>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var itemImg : ImageView
        var itemTitle : TextView
        var itemDesc : TextView

        init {
            itemImg = itemView.findViewById(R.id.itemImg)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDesc = itemView.findViewById(R.id.itemDesc)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,
                    "Clicked ${itemsList[adapterPosition].name}.",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        called when RecyclerView needs a new ViewHolder Instance
//        inflating the layout for a single item and returning a new ViewHolder
//        viewGroup : is the parent view that the new view will be attached to after it's bound to its data
//        viewType : in many cases you might have only one type of view used to distinguish between different types of views

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemTitle.setText(itemsList[position].name)
        holder.itemDesc.setText(itemsList[position].desc)
        holder.itemImg.setImageResource(itemsList[position].img)

    }

}