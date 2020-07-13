package com.example.moviesapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.models.Movie

class MovieRecyclerViewAdapter(var context: Context, var moviesList : List<Movie>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {


    class MovieViewHolder(var movieItemView: View) : RecyclerView.ViewHolder(movieItemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.movie_item_layout,
                parent, false))
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
    }
}