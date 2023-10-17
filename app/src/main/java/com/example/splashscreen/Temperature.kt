package com.example.splashscreen

import android.util.Log

class Temperature {
    companion object {
        var unit = arrayOf("celcius", "farenheit", "kelvin")
    }
    fun convertTemperature(input1: Double, unitType1: String, unitType2: String): Double {
        Log.d("input1",input1.toString())
        var result = 0.0

        if (unitType1.equals(unit[0]) && unitType2.equals(unit[1])) {
            result = (input1 * 9/5) + 32
        }
        if (unitType1.equals(unit[0]) && unitType2.equals(unit[2])) {
            result = input1 + 273.15
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[2])) {
            result = (input1 - 32) * 5/9 + 273.15
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[0])) {
            result = (input1 - 32) * 5/9
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[0])) {
            result = input1 - 273.15
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[1])) {
            result = (input1 - 273.15) * 9/5 + 32
        }
        return result
    }

    fun getUnit(): Array<String> {
        return unit
    }
}