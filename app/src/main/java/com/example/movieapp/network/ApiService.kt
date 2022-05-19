package com.example.movieapp.network

import com.example.movieapp.network.model.MovieData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/")
    suspend fun getQueryMovies(
        @Query("apikey") apiKey: String,
        @Query("s") query: String
    ): MovieData
}