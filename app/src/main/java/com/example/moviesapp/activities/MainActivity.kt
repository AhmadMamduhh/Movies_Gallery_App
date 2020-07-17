package com.example.moviesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.moviesapp.R
import com.example.moviesapp.data.MovieServiceInterface
import com.example.moviesapp.data.RetrofitClient
import com.example.moviesapp.models.Movie
import com.example.moviesapp.models.MovieResponse
import com.example.moviesapp.repositries.MovieRepositry
import com.example.moviesapp.repositries.MovieRepositryInterface
import com.example.moviesapp.ui.MovieRecyclerViewAdapter
import com.example.moviesapp.util.Utils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MovieRepositryInterface {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MovieRepositry.getPopularMovies(this,this)
        MovieRepositry.getTopRated(this, this)

    }

    override fun getPopularMovies(movieList: List<Movie>) {
        popularRecyclerView.adapter = MovieRecyclerViewAdapter(
            this@MainActivity, movieList)
    }

    override fun getTopRatedMovies(movieList: List<Movie>) {
        topRatedRecyclerView.adapter = MovieRecyclerViewAdapter(
            this@MainActivity, movieList)

    }
}

