package com.andygeek.listviewadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DevAdapter(private val context: Context, private val dataSource: ArrayList<Dev>) : BaseAdapter(){

    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private lateinit var rowView : View

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val viewHolder : ViewHolder
        println(parent)

        if (convertView == null){
            rowView = inflater.inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(rowView)
            rowView.tag = viewHolder
            println("Primero = " + rowView.tag)
        }else{
            rowView = convertView
            println("Segundo = " + rowView.tag)
            viewHolder = rowView.tag as ViewHolder
        }

        viewHolder.itemId.text = dataSource[position].id.toString()
        viewHolder.itemName.text = dataSource[position].name
        viewHolder.itemLanguage.text = dataSource[position].language

        return rowView
    }

    private class ViewHolder(view : View){
        val itemId = view.findViewById(R.id.txt_id) as TextView
        val itemName = view.findViewById(R.id.txt_name) as TextView
        val itemLanguage = view.findViewById(R.id.txt_language) as TextView
    }
}