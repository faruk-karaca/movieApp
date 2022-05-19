package com.example.movieapp.network.model

data class MovieData(
    val Response: String,
    val Search: List<Search>,
    val totalResults: String
)