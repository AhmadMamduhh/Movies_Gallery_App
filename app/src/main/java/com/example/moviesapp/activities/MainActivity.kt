package com.example.moviesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import com.example.moviesapp.R
import com.example.moviesapp.models.Movie
import com.example.moviesapp.ui.MovieRecyclerViewAdapter
import com.example.moviesapp.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    val mainActivityViewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel.getPopularMovies().observe(this)
        { movies ->
            val recyclerAdapter = MovieRecyclerViewAdapter(this, movies)
            popularRecyclerView.adapter = recyclerAdapter
        }
        mainActivityViewModel.getTopRatedMovies().observe(this)
        {movies ->  val recyclerAdapter = MovieRecyclerViewAdapter(this, movies)
                topRatedRecyclerView.adapter = recyclerAdapter}


    }


}

