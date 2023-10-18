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
    fun addTemperature(input1: Double = 0.0, input2: Double = 0.0, unitType1: String, unitType2: String, unitType3: String): Double {
        var newInput1: Double
        var newInput2: Double
        var result: Double

        if (unitType1.equals(Length.unit[1])) {
            newInput1 = (input1 - 32) * 5/9
        } else if (unitType1.equals(Length.unit[2])) {
            newInput1 = input1 - 273.15
        } else {
            newInput1 = input1
        }
        if (unitType2.equals(Length.unit[2])) {
            newInput2 = input1 - 273.15
        } else if (unitType2.equals(Length.unit[1])) {
            newInput2 = (input1 - 32) * 5/9
        } else {
            newInput2 = input2
        }

        if(unitType3.equals(Length.unit[0])){
            result = newInput1 + newInput2
            return result }
        else if (unitType3.equals(Length.unit[1])) {
            result = ((newInput1 + newInput2) * 9/5) + 32
            return result
        } else {
            result = (newInput1 + newInput2) + 273.15
            return result
        }
    }
    fun getUnit(): Array<String> {
        return unit
    }
}