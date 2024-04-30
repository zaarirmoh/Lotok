package com.example.lotok.network

import com.example.lotok.model.CarPost
import com.example.lotok.model.Category
import retrofit2.http.GET

interface LotokApiService {
    @GET("categories")
    suspend fun getCategories(): List<Category>

    @GET("posts")
    suspend fun getPosts(): List<CarPost>
}