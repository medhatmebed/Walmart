package com.example.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class AppleWatch : AppCompatActivity() {

    var clothingList = arrayOf("Series 1", "Series 2", "Series 3", "Series 4")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apple_watch)

        val adapter = ArrayAdapter(this, R.layout.list_view_apple_watch, clothingList)
        val listView: ListView = findViewById(R.id.listview_applewatch)
        listView.adapter  = adapter

        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val itemClothingView = listView.getItemAtPosition(position) as String
                Toast.makeText(applicationContext, "You have selected ${itemClothingView}", Toast.LENGTH_SHORT).show()
            }
        }

    }
}