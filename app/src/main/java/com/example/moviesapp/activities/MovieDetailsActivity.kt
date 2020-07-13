package com.example.moviesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val bundle = intent.extras
        Picasso.get().load("https://image.tmdb.org/t/p/w500/${bundle?.getString("Poster Path")}")
                .into(posterImageView)
        titleText.text = bundle?.getString("Title")
        overviewText.text = bundle?.getString("Overview")
        ratingText2.text = bundle?.getString("Rating")
        val unformattedDate = bundle?.getString("Release Date")
        var formattedDate = "${unformattedDate?.substring(8,10)}-${unformattedDate?.substring(5,7)}-" +
                "${unformattedDate?.substring(0,4)} "
        releaseDateText.text = formattedDate


    }
}
