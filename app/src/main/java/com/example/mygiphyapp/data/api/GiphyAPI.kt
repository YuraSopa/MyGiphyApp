package com.example.mygiphyapp.data.api

import com.example.mygiphyapp.data.models.GiphyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GiphyAPI {

    @GET("trending")
    suspend fun getTrendingGifs(
        @Query("api_key")
        apiKey: String,
        @Query("limit")
        limit: Int,
        @Query("offset")
        offset: Int,
    ): Response<GiphyResponse>


    @GET("search")
    suspend fun getSearchGifs(
        @Query("api_key")
        apiKey: String,
        @Query("q")
        searchQuery: String,
        @Query("limit")
        limit: Int,
        @Query("offset")
        offset: Int,
    ): Response<GiphyResponse>
}