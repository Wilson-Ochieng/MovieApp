package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.movieapp.ui.MovieDetailsScreen
import com.example.movieapp.ui.MovieListScreen
import com.example.movieapp.viewmodel.MovieViewModel

@Composable
fun NavGraph(navController: NavHostController, viewModel: MovieViewModel) {
    val movies = viewModel.movies.value ?: emptyList()

    NavHost(navController = navController, startDestination = "movieList") {
        composable("movieList") {
            MovieListScreen(navController, movies)
        }
        composable(
            "details/{movieId}",
            arguments = listOf(navArgument("movieId") { type = androidx.navigation.NavType.IntType })
        ) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getInt("movieId")
            val movie = movies.find { it.id == movieId }
            movie?.let { MovieDetailsScreen(it) }
        }
    }
}
