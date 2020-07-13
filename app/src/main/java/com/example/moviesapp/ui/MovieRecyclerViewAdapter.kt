package com.example.moviesapp.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.activities.MovieDetailsActivity
import com.example.moviesapp.models.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item_layout.view.*

class MovieRecyclerViewAdapter(var context: Context, var moviesList : List<Movie>) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>() {


   inner class MovieViewHolder(var movieItemView: View) : RecyclerView.ViewHolder(movieItemView) {
       var movieImage = movieItemView.moviePosterImage
       var movieRating = movieItemView.ratingText1

       fun bindMovieItem(movie : Movie){
           Picasso.get().load("https://image.tmdb.org/t/p/w300/${movie.posterPath}").into(movieImage)
           movieRating.text = movie.voteAverage
           movieItemView.setOnClickListener{ startDetailsActivity(movie) }
       }

       fun startDetailsActivity(movie : Movie){
           val intent = Intent(context, MovieDetailsActivity::class.java ).apply{
               putExtra("Title", movie.title)
               putExtra("Rating", movie.voteAverage)
               putExtra("Poster Path", movie.posterPath)
               putExtra("Release Date", movie.releaseDate)
               putExtra("Overview", movie.overview)
               context.startActivity(this)
           }
       }


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
        holder.bindMovieItem(moviesList[position])
    }
}