package com.example.splashscreen

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class AddQuantityModel( var selectedOption: String?,
                              var selectedUnit1: String?,
                              var selectedUnit2: String?,
                              var inputValue: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(selectedOption)
        parcel.writeString(selectedUnit1)
        parcel.writeString(selectedUnit2)
        parcel.writeString(inputValue)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddQuantityModel> {
        override fun createFromParcel(parcel: Parcel): AddQuantityModel {
            return AddQuantityModel(parcel)
        }

        override fun newArray(size: Int): Array<AddQuantityModel?> {
            return arrayOfNulls(size)
        }
    }

}