package com.example.lotok.data

import androidx.annotation.DrawableRes
import com.example.lotok.R
data class ProfileInformation(
    val name: String,
    @DrawableRes val picture: Int,
    val email: String,
    val carsPosted: Int,
    val postsSaved: Int,
    val bookings: Int,
    val firstName: String? = null,
    val lastName: String? = null,
    val location: String? = null,
    val mobileNumber: String? = null
)
val profileInformation = ProfileInformation(
    name = "Mohamed",
    picture = R.drawable.baseline_boy_24,
    email = "mr.zaarir@esi-sba.dz",
    carsPosted = 360,
    postsSaved = 238,
    bookings = 473,
)
