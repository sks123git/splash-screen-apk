package com.example.splashscreen

import android.util.Log

class Currency {
    companion object {
        var unit = arrayOf("rupee", "dollar", "euro")
    }
    fun convertCurrency(input1: Double, unitType1: String, unitType2: String): Double {
        Log.d("input1",input1.toString())
        var result = 0.0
        val rupeeDollarEquivalent = 83.28
        val dollarRupeeEquivalent = 0.012
        val euroDollarEquivalent = 1.05
        val dollarEuroEquivalent = 0.95
        val rupeeEuroEquivalent = 0.011
        val euroRupeeEquivalent = 87.71

        if (unitType1.equals(unit[0]) && unitType2.equals(unit[1])) {
            result = input1 * dollarRupeeEquivalent
        }
        if (unitType1.equals(unit[0]) && unitType2.equals(unit[2])) {
            result = input1 * rupeeEuroEquivalent
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[2])) {
            result = input1 * dollarEuroEquivalent
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[0])) {
            result = input1 * rupeeDollarEquivalent
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[0])) {
            result = input1 * euroRupeeEquivalent
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[1])) {
            result = input1 * euroDollarEquivalent
        }
        return result
    }

    fun getUnit(): Array<String> {
        return unit
    }
}