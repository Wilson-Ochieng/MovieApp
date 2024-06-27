package com.example.movieapp

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.navigation.NavGraph
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.viewmodel.MovieViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    topBar = {
                        TopAppBar(
                            modifier = Modifier.fillMaxWidth(),
                            title = {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    Text(
                                        text = "Movie App",
                                        modifier = Modifier.padding(horizontal = 16.dp), // Adjust padding as needed
                                        color = MaterialTheme.colorScheme.primary, // Text color
                                    )
                                }
                            }
                        )
                    }
                )

                {
                    val navController = rememberNavController()
                    val viewModel: MovieViewModel by viewModels()
                    NavGraph(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        val navController = rememberNavController()
        val viewModel = MovieViewModel()
        NavGraph(navController = navController, viewModel = viewModel)
    }
}
