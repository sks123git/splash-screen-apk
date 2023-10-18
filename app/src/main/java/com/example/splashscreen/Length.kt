package com.example.splashscreen

import android.util.Log

class Length {
    companion object {
        var unit = arrayOf("mm", "cm", "meter")
    }
    fun calculateLength(input1: Double, unitType1: String, unitType2: String): Double {
        Log.d("input1",input1.toString())
        var result = 0.0
        if (unitType1.equals(unit[0]) && unitType2.equals(unit[1])) {
            result = input1/10
        }
        if (unitType1.equals(unit[0]) && unitType2.equals(unit[2])) {
            result = input1/1000
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[2])) {
            result = input1/100
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[0])) {
            result = input1 * 10
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[0])) {
            result = input1 * 1000
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[1])) {
            result = input1 * 100
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[1])) {
            result = input1 * 100
        }
        return result
    }

    fun addLength(input1: Double = 0.0, input2: Double = 0.0, unitType1: String, unitType2: String, unitType3: String): Double {
        var newInput1: Double
        var newInput2: Double
        var result: Double

        if (unitType1.equals(unit[1])) {
            newInput1 = input1 * 10
        } else if (unitType1.equals(unit[2])) {
            newInput1 = input1 * 1000
        } else {
            newInput1 = input1
        }
        if (unitType2.equals(unit[2])) {
            newInput2 = input2 * 1000
        } else if (unitType2.equals(unit[1])) {
            newInput2 = input2 * 10
        } else {
            newInput2 = input2
        }

        if(unitType3.equals(unit[0])){
        result = newInput1 + newInput2
        return result }
        else if (unitType3.equals(unit[1])) {
            result = (newInput1 + newInput2) / 10
            return result
        } else {
            result = (newInput1 + newInput2) / 1000
            return result
        }
        }
    fun getUnit(): Array<String> {
        return unit
    }
}