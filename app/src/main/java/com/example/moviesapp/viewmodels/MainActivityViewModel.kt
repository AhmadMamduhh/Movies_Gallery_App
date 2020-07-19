package com.example.moviesapp.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.models.Movie
import com.example.moviesapp.repositries.MovieRepositry


class MainActivityViewModel : ViewModel() {


    fun getPopularMovies(): LiveData<List<Movie>>{
        return MovieRepositry.getPopularMovies()
    }

    fun getTopRatedMovies(): LiveData<List<Movie>>{
        return MovieRepositry.getTopRated()
    }



}