package com.example.lotok.data

import com.example.lotok.model.CarPost
import com.example.lotok.model.Category
import com.example.lotok.network.LotokApiService

/**
 * Repository that fetch mars photos list from marsApi.
 */
interface LotokRepository {
    /** Fetches list of MarsPhoto from marsApi */
    suspend fun getLotokCategories(): List<Category>

    suspend fun getLotokPosts(): List<CarPost>
}

/**
 * Network Implementation of Repository that fetch mars photos list from marsApi.
 */
class NetworkLotokRepository(
    private val marsApiService: LotokApiService
) : LotokRepository {
    /** Fetches list of MarsPhoto from marsApi*/
    override suspend fun getLotokCategories(): List<Category> = marsApiService.getCategories()

    override suspend fun getLotokPosts(): List<CarPost> = marsApiService.getPosts()
}