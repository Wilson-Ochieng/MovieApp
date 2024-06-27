package com.example.movieapp.viewmodel
import androidx.lifecycle.*
import com.example.movieapp.network.Movie
import com.example.movieapp.network.RetrofitInstance
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> get() = _movies

    init {
        fetchMovies()
    }


    private fun fetchMovies() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getPopularMovies("056526ee8518b470c52775f1dad739d7")
            _movies.postValue(response.results)
        }
    }


}