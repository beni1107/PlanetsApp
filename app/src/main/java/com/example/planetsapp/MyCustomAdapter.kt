package com.example.planetsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MyCustomAdapter(val context: Context, val planets:List<Planet>): BaseAdapter(){
    //returns the number size of list
    override fun getCount() = planets.size

   //returns the data item associated with the specifid positon
    override fun getItem(position: Int): Any? {
        return planets.getOrNull(position
        )
    }
    // //returns the unique identifier for the item at the specificed position
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

  /*  //Returns a View that displays the data at the specified position on the list
    override fun getView(
        position: Int, // position
        convertView: View?, // receycled view - can be resued
        parent: ViewGroup? // to attach
    ): View? {

        val inflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        //val infaltor = LayoutInflator.from(context)  krajse kot zgoraj

        val view: View
        if (convertView == null) {
            view  = inflater.inflate(R.layout.item_list_layout,parent,false)

        }else {
            //Reuse the convertivew
            view = convertView
        }

        //Bind data to the view
        val item = getItemId(position) as Planet
        //initilazile views
        val titletextView = view.findViewById<TextView>(R.id.planet_name)
        val moonCounttextView = view.findViewById<TextView>(R.id.moon_count_text)
        val moon_image = view.findViewById<ImageView>(R.id.imageView)

        titletextView.text = item.title
        moonCounttextView.text = item.moonCount
        moon_image.setImageResource(item.imagePLanet)

        return view

    }*/

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View {


        val inflater = LayoutInflater.from(context) // krajše kot getSystemService
        val view = convertView ?: inflater.inflate(R.layout.item_list_layout, parent, false)

        //Bind data to the view
        val item = getItem(position) as Planet  // <-- tukaj vzamemo item iz getItem()

        val titleTextView = view.findViewById<TextView>(R.id.planet_name)
        val moonCountTextView = view.findViewById<TextView>(R.id.moon_count_text)
        val moonImage = view.findViewById<ImageView>(R.id.imageView)

        titleTextView.text = item.title
        moonCountTextView.text = item.moonCount
        moonImage.setImageResource(item.imagePLanet)


        //handle clikc events
        view.setOnClickListener {
            Toast.makeText(context,"You clicked :${planets.get(position).title}", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}