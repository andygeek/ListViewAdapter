package com.andygeek.listviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var btnAdd : Button
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lista : ArrayList<Dev>
        lista = arrayListOf()

        listView = findViewById(R.id.list_view)
        btnAdd = findViewById(R.id.btn_add)

        val adapter = DevAdapter(this, lista)
        listView.adapter = adapter

        btnAdd.setOnClickListener {
            val temp = Dev(1, "Andy", "C++")
            lista.add(temp)
            adapter.notifyDataSetChanged()
        }
    }
}