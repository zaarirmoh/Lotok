package com.example.lotok.data

import androidx.annotation.DrawableRes
import com.example.lotok.R
data class Category(
    @DrawableRes val imgSrc: Int
)

val categories = listOf(
    Category(R.drawable.car_category),
    Category(R.drawable.motorcycle_category),
    Category(R.drawable.master_category),
    Category(R.drawable.truck_category)
)