package com.singpaulee.made_dicoding.views.detailmovie

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.model.MovieModel
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.toast


class DetailMovieActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<MovieModel>("movie")

        dma_tv_title.text = movie.title
        dma_tv_overview.text = movie.description
        dma_tv_rating.text = movie.rating.toString()
        Glide.with(this)
            .load(movie.image)
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dma_iv_poster)


        dummyFunction()
    }

    private fun dummyFunction() {
        dma_tv_favorite.visibility = View.GONE
        dma_tv_duration.visibility = View.GONE
        dma_tv_popularity.text = "-"
        dma_tv_vote_count.text = "-"
    }
}
