package com.example.lotok.data

import androidx.annotation.DrawableRes


data class CarPost(
    val id: Int,
    @DrawableRes val imgSrc: Int,
    val name: String,
    val year: Int,
    val mark: String,
    val engine: String,
    val dayPrice: Int,
    val weekPrice: Int,
    val rating: Double,
)