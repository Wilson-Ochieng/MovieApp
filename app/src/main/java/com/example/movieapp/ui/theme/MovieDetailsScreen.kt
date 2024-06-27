package com.example.movieapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.movieapp.network.Movie
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieDetailsScreen(movie: Movie) {
    Column(modifier = Modifier.padding(16.dp)) {

        GlideImage(
            model = "https://image.tmdb.org/t/p/w500${movie.backdropPath}",
            contentDescription = "Movie Backdrop",
            modifier = Modifier
                .size(240.dp)
                .padding(bottom = 16.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = movie.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "User Score: ${movie.vote_average}%", style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.height(4.dp))
        PlayTrailerButton(onClick = { /* Handle trailer play */ })
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Overview", style = MaterialTheme.typography.titleSmall)
        Text(text = movie.overview, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun PlayTrailerButton(onClick: (

        ) -> Unit) {

}
