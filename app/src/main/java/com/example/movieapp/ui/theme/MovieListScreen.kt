package com.example.movieapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieapp.network.Movie

@Composable
fun MovieListScreen(navController: NavController, movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieItem(movie) {
                navController.navigate("details/${movie.id}")
            }
        }
    }
}
