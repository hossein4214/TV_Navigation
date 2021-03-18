package com.example.tvbottomnavigation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Barber(
        val name: String ,
        val barberId: String
) : Parcelable

