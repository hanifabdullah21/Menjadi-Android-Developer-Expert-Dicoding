package com.singpaulee.made_dicoding.views.detailmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import kotlinx.android.synthetic.main.activity_detail_movie.*


class DetailMovieActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val movie = intent.getParcelableExtra<DescriptionMovieModel>(ConstantTemplate.ARG_MOVIE)

        Glide.with(this)
            .load(BuildConfig.BASEURLIMAGE + "${movie.posterPath}")
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dma_iv_poster)

        dma_viewgroup_adult.visibility =
            if (movie.adult == true) View.VISIBLE else View.INVISIBLE
        dma_tv_overview.text =
            if (movie.overview == null || movie.overview == "") resources.getString(R.string.string_overview_has_not_exist) else movie.overview
        dma_tv_title.text = movie.originalTitle.toString()
        dma_tv_year.text = movie.releaseDate.toString()
        dma_tv_rating.text = movie.voteAverage.toString()
        dma_tv_popularity.text =
            if (movie.popularity == null) "-" else String.format("%.1f", movie.popularity)
        dma_tv_vote_count.text =
            if (movie.voteCount == null) "-" else movie.voteCount.toString()



        dummyFunction()
    }

    private fun dummyFunction() {
//        dma_tv_favorite.visibility = View.GONE
        dma_tv_duration.visibility = View.GONE
    }
}
