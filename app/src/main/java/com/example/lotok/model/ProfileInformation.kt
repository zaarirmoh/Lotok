package com.example.lotok.model

import androidx.annotation.DrawableRes
import com.example.lotok.R
data class ProfileInformation(
    var name: String,
    @DrawableRes val picture: Int,
    var email: String,
    var carsPosted: Int,
    var postsSaved: Int,
    var bookings: Int,
    var firstName: String = "",
    var lastName: String = "",
    var location: String = "",
    var mobileNumber: String = "",
)
val profileInformation = ProfileInformation(
    name = "Mohamed",
    picture = R.drawable.profile_picture,
    email = "mr.zaarir@esi-sba.dz",
    carsPosted = 360,
    postsSaved = 238,
    bookings = 473,
    firstName = "Mohamed",
    lastName = "Zaarir",
    location = "Soumaa",
    mobileNumber = "0776325625"
)
