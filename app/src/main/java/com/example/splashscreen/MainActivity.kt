package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import layout.GridAdapter

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
    var nameList = ArrayList<String>()
    var imageList = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.grid_view)
        fillArrays()

        val adapter = GridAdapter(nameList,imageList,this@MainActivity)
        gridView.adapter = adapter
    }

    fun fillArrays() {
        nameList.add("Time")
        nameList.add("Currency")
        nameList.add("Lengths")

        imageList.add(R.drawable.back_in_time)
        imageList.add(R.drawable.different_currencies)
        imageList.add(R.drawable.different_lengths)
    }
}