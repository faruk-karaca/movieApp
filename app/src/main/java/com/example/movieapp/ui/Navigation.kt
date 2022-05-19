package com.example.movieapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.ui.components.DetailContent
import com.example.movieapp.ui.components.MainContent
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainContent.route) {
        composable(route = Screen.MainContent.route) {
            MainContent(navController = navController)
        }
        composable(
            route = Screen.DetailContent.route + "/{title}/{imdbId}/{type}/{year}/{poster}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                    defaultValue = "null"
                },
                navArgument("poster") {
                    type = NavType.StringType
                    defaultValue = "null"
                },
                navArgument("type") {
                    type = NavType.StringType
                    defaultValue = "null"
                },
                navArgument("year") {
                    type = NavType.StringType
                    defaultValue = "null"
                },
                navArgument("imdbId") {
                    type = NavType.StringType
                    defaultValue = "null"
                }
            )
        ) { entry ->

            val poster = URLDecoder.decode(
                entry.arguments?.getString("poster"),
                StandardCharsets.UTF_8.toString()
            )
            val title = URLDecoder.decode(
                entry.arguments?.getString("title"),
                StandardCharsets.UTF_8.toString()
            )
            val type = URLDecoder.decode(
                entry.arguments?.getString("type"),
                StandardCharsets.UTF_8.toString()
            )
            val year = URLDecoder.decode(
                entry.arguments?.getString("year"),
                StandardCharsets.UTF_8.toString()
            )
            val imdbId = URLDecoder.decode(
                entry.arguments?.getString("imdbId"),
                StandardCharsets.UTF_8.toString()
            )

            DetailContent(title!!, imdbId!!, type!!, year!!, poster)
        }
    }
}