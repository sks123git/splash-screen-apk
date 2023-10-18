package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class AddQuantityActivity : AppCompatActivity() {
    lateinit var mySpinner: Spinner
    lateinit var mySpinner2: Spinner
    lateinit var mySpinner3: Spinner
    lateinit var mySpinner4: Spinner
    lateinit var dismiss: Button
    lateinit var addResultText: TextView
    lateinit var addUnits: Button
    lateinit var inputText1: EditText
    lateinit var inputText2: EditText
    lateinit var lengthClass: Length
    lateinit var currencyClass: Currency
    lateinit var temperatureClass: Temperature
    lateinit var selectedItem: String
    var getUnit = arrayOf("")
    lateinit var unitType1: String
    lateinit var unitType2: String
    lateinit var unitType3: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quantity)
        val units = resources.getStringArray(R.array.units)
        mySpinner = findViewById(R.id.mySpinnerAdd)
        inputText1 = findViewById(R.id.enter1stUnit)
        inputText2 = findViewById(R.id.enter2ndUnit)
        mySpinner2 = findViewById(R.id.spinner2)
        mySpinner3 = findViewById(R.id.spinner3)
        mySpinner4 = findViewById(R.id.spinner4)
        addResultText = findViewById(R.id.addResultText)

        val object1 = intent.getParcelableExtra<AddQuantityModel>("data")
        Log.i("InputValue", object1?.inputValue.toString())
        inputText1.setText(object1?.inputValue.toString())
        inputText2.setText(object1?.inputValue.toString())

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
                    selectedItem = adapterView?.getItemAtPosition(position).toString()
                    if (selectedItem == "Length") {
                        lengthClass = Length()
                        getUnit = lengthClass.getUnit()
                        setSpinner2()
                        setSpinner3()
                        setSpinner4()
                    } else if (selectedItem == "Currency") {
                        currencyClass = Currency()
                        getUnit = currencyClass.getUnit()
                        setSpinner2()
                        setSpinner3()
                        setSpinner4()
                    } else if (selectedItem == "Temperature") {
                        temperatureClass = Temperature()
                        getUnit = temperatureClass.getUnit()
                        setSpinner2()
                        setSpinner3()
                        setSpinner4()
                    } else {
                        println("enter selection")
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }

        addUnits = findViewById(R.id.result)

        addUnits.setOnClickListener {
            val input1 = inputText1.text.toString()
            val input2 = inputText2.text.toString()
            if (!input1.isEmpty() && !input2.isEmpty()) {
                if (selectedItem.equals("Length")) {
                    addResultText.text =
                        lengthClass.addLength(
                            input1.toDouble(),
                            input2.toDouble(),
                            unitType1,
                            unitType2,
                            unitType3
                        )
                            .toString()
                } else if (selectedItem.equals("Currency")) {
                    addResultText.text =
                        currencyClass.addCurrency(input1.toDouble(),input2.toDouble(), unitType1, unitType2, unitType3)
                            .toString()
                } else if (selectedItem.equals("Temperature")) {
                    addResultText.text =
                        temperatureClass.addTemperature(
                            input1.toDouble(),
                            input2.toDouble(),
                            unitType1,
                            unitType2,
                            unitType3
                        )
                            .toString()
                } else {
                    Toast.makeText(
                        this@AddQuantityActivity,
                        "Something went wrong",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }
            } else {
                Toast.makeText(this@AddQuantityActivity, "Enter values", Toast.LENGTH_LONG)
                    .show()
            }
        }

        setOnHideButton()
    }

        fun setSpinner2() {
            if (mySpinner2 != null) {
                val adapter1 = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, getUnit
                )
                mySpinner2.adapter = adapter1
                mySpinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
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
                    android.R.layout.simple_spinner_item, getUnit
                )
                mySpinner3.adapter = adapter2
                mySpinner3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        unitType2 = adapterView?.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {}
                }
            }
        }

        fun setSpinner4() {
            if (mySpinner4 != null) {
                val adapter3 = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, getUnit
                )
                mySpinner4.adapter = adapter3
                mySpinner4.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        adapterView: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        unitType3 = adapterView?.getItemAtPosition(position).toString()
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {}
                }
            }
        }

    fun setOnHideButton() {
        dismiss = findViewById(R.id.dismiss)
        dismiss.setOnClickListener {
            finish()
        }
    }
    }