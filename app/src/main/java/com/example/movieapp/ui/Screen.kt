package com.example.movieapp.ui

import java.net.URLEncoder
import java.nio.charset.StandardCharsets

sealed class Screen(val route: String) {
    object DetailContent : Screen("detail_content")
    object MainContent : Screen("main_content")

    fun withArgs(vararg args: String): String {

        val url = buildString {
            append(route)
            args.forEach { arg ->
                append("/${URLEncoder.encode(arg, StandardCharsets.UTF_8.toString())}")
            }
        }
        return url
    }
}
