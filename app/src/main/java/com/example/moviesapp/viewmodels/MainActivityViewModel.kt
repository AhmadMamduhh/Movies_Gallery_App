package com.example.moviesapp.viewmodels
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.database.MoviesDatabase
import com.example.moviesapp.models.Movie
import com.example.moviesapp.repositries.MovieRepositry


class MainActivityViewModel(private val app: Application) : AndroidViewModel(app) {
    init {
        MovieRepositry.createDatabase(app)
    }


    fun getPopularMovies(): LiveData<List<Movie>>{
        return MovieRepositry.getPopularMovies()
    }

    fun getTopRatedMovies(): LiveData<List<Movie>>{
        return MovieRepositry.getTopRated()
    }



}