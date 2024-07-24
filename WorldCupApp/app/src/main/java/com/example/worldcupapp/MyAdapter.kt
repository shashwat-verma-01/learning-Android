package com.example.worldcupapp

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MyAdapter(private var activity: Activity, private var items : ArrayList<CountryModelClass>) : BaseAdapter(){
    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(p0: Int): Any {
        return items[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    // generating items view
    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val view : View?
        val viewHolder : ViewHolder

        if(p1 == null){
            val inflator = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            view = inflator.inflate(R.layout.list_item, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }
        else{
            view = p1
            viewHolder = view.tag as ViewHolder
        }

        var countries = items[position]
        viewHolder.txtName?.text = countries.name
        viewHolder.txtCupWin?.text = countries.cupWins
        viewHolder.flagImg?.setImageResource(countries.flagImg)

        view?.setOnClickListener(){
            Toast.makeText(activity,
                "You Chose: ${countries.name}",
                Toast.LENGTH_SHORT).show()
        }

        return view as View
    }

    private class ViewHolder(row : View?){
        var txtName : TextView? = null
        var txtCupWin : TextView?= null
        var flagImg : ImageView? = null

        init{
            this.txtName = row?.findViewById(R.id.countryName)
            this.txtCupWin = row?.findViewById(R.id.totalWins)
            this.flagImg = row?.findViewById(R.id.imageView)
        }
    }

}