package com.example.splashscreen

import android.util.Log

class Currency {
    companion object {
        var unit = arrayOf("rupee", "dollar", "euro")
    }
    enum class Equivalent(val values: Double) {
         rupeeDollarEquivalent(83.28),
        dollarRupeeEquivalent(0.012),
        euroDollarEquivalent(1.05),
         dollarEuroEquivalent(0.95),
         rupeeEuroEquivalent(0.011),
         euroRupeeEquivalent(87.71)
    }
    fun convertCurrency(input1: Double, unitType1: String, unitType2: String): Double {
        Log.d("input1",input1.toString())
        var result = 0.0

        if (unitType1.equals(unit[0]) && unitType2.equals(unit[1])) {
            result = input1 * Equivalent.dollarRupeeEquivalent.values
        }
        if (unitType1.equals(unit[0]) && unitType2.equals(unit[2])) {
            result = input1 * Equivalent.rupeeEuroEquivalent.values
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[2])) {
            result = input1 * Equivalent.dollarEuroEquivalent.values
        }
        if (unitType1.equals(unit[1]) && unitType2.equals(unit[0])) {
            result = input1 * Equivalent.rupeeDollarEquivalent.values
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[0])) {
            result = input1 * Equivalent.euroRupeeEquivalent.values
        }
        if (unitType1.equals(unit[2]) && unitType2.equals(unit[1])) {
            result = input1 * Equivalent.euroDollarEquivalent.values
        }
        return result
    }
    fun addCurrency(input1: Double = 0.0, input2: Double = 0.0, unitType1: String, unitType2: String, unitType3: String): Double {
        var newInput1: Double
        var newInput2: Double
        var result: Double

        if (unitType1.equals(Length.unit[1])) {
            newInput1 = input1 * Equivalent.rupeeDollarEquivalent.values
        } else if (unitType1.equals(Length.unit[2])) {
            newInput1 = input1 * Equivalent.euroRupeeEquivalent.values
        } else {
            newInput1 = input1
        }
        if (unitType2.equals(Length.unit[2])) {
            newInput2 = input2 * Equivalent.euroRupeeEquivalent.values
        } else if (unitType2.equals(Length.unit[1])) {
            newInput2 = input2 * Equivalent.rupeeDollarEquivalent.values
        } else {
            newInput2 = input2
        }

        if(unitType3.equals(Length.unit[0])){
            result = newInput1 + newInput2
            return result }
        else if (unitType3.equals(Length.unit[1])) {
            result = (newInput1 + newInput2) * Equivalent.dollarRupeeEquivalent.values
            return result
        } else {
            result = (newInput1 + newInput2) * Equivalent.rupeeEuroEquivalent.values
            return result
        }
    }
    fun getUnit(): Array<String> {
        return unit
    }
}