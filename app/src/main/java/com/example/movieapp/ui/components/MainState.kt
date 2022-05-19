package com.example.movieapp.ui.components

import com.example.movieapp.network.model.Search


data class MainState(
    val isLoading: Boolean = false,
    val data: List<Search> = emptyList(),
    val error: String = ""
)