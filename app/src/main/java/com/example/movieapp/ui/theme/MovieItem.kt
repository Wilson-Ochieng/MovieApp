package com.example.movieapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.movieapp.network.Movie

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieItem(movie: Movie, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = if (movie.backdropPath.isNullOrEmpty()) {
                    // Use a default placeholder image URL or local resource
                    "https://image.tmdb.org/t/p/w500/1E5baAaEse26fej7uHcjOgEE2t2.jpg"
                } else {
                    "https://image.tmdb.org/t/p/w500${movie.backdropPath}"
                },
                contentDescription = "Movie Backdrop",
                modifier = Modifier
                    .size(240.dp)
                    .padding(bottom = 16.dp),
                contentScale = ContentScale.Crop,
                // Optional: Specify error and loading placeholders
                // error = R.drawable.placeholder_error,
                // loading = R.drawable.placeholder_loading
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
}
