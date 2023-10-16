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

    fun getUnit(): Array<String> {
        return unit
    }
}