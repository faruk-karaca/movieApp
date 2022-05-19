package com.example.movieapp.ui.components

import com.example.movieapp.network.ApiService
import com.example.movieapp.network.model.MovieData
import com.example.movieapp.util.Constant
import com.example.movieapp.util.Resource
import javax.inject.Inject


class MainRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQueryItems(q: String): Resource<MovieData> {
        return try {
            val result = apiService.getQueryMovies(query = q, apiKey = Constant.KEY)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}