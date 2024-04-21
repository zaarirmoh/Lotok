package com.example.lotok.data



data class CarPost(
    val id: Int,
    val imgSrc: String,
    val name: String,
    val year: Int,
    val mark: String,
    val engine: String,
    val dayPrice: Int,
    val weekPrice: Int,
    val rating: Int,
)