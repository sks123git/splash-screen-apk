package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var mySpinner: Spinner
    lateinit var mySpinner2: Spinner
    lateinit var mySpinner3: Spinner
    lateinit var inputText: EditText
    lateinit var lengthClass: Length
    lateinit var result: Button
    lateinit var  textView: TextView
    var unitType1 = ""
    var unitType2 = ""
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            val units = resources.getStringArray(R.array.units)
            mySpinner = findViewById(R.id.mySpinner)
            inputText = findViewById(R.id.enter1stUnit)
            mySpinner2 = findViewById(R.id.spinner2)
            mySpinner3 = findViewById(R.id.spinner3)
            textView = findViewById(R.id.enter2ndUnit)

            if (mySpinner != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, units
                )
                mySpinner.adapter = adapter

                mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        var selectedItem = adapterView?.getItemAtPosition(position).toString()

                        if (selectedItem == "Length") {
                            lengthClass = Length()
                            setSpinner2()
                            setSpinner3()
                        } else {
                            println("enter selection")
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }
                }
            }

            result = findViewById(R.id.result)

            result.setOnClickListener {
                val input = inputText.text.toString()
                if (unitType1 != unitType2) {
                    textView.text =
                        lengthClass.calculateLength(input.toDouble(), unitType1, unitType2)
                            .toString()
                } else {
                    Toast.makeText(this@MainActivity,"Enter different unit",Toast.LENGTH_LONG).show()
                }
            }
        }
    fun setSpinner2() {
        if (mySpinner2 != null) {
            val adapter1 = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, lengthClass.getUnit()
            )
            mySpinner2.adapter = adapter1
            mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    unitType1 = adapterView?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        }
    }

    fun setSpinner3() {
        if (mySpinner3 != null) {
            val adapter2 = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, lengthClass.getUnit()
            )
            mySpinner3.adapter = adapter2
            mySpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    unitType2 = adapterView?.getItemAtPosition(position).toString()
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        }
    }
}