package com.example.lotok.data

data class CarPost(
    val id: Int,
    val imgSrc: List<Int>,
    val name: String,
    val year: Int,
    val mark: String,
    val engine: String,
    val dayPrice: Int,
    val weekPrice: Int,
    val rating: Double,
    val description: String? = null,
    val location : String = "mila" ,
    val type : String = "manuel" ,
    val energyType : String = "DZL",
    val seats : Int = 4,

)



