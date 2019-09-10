package com.singpaulee.made_dicoding.views.detailmovie

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.singpaulee.made_dicoding.BuildConfig
import com.singpaulee.made_dicoding.R
import com.singpaulee.made_dicoding.bank.ConstantTemplate
import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.jetbrains.anko.toast


class DetailMovieActivity : AppCompatActivity(), DetailMovieView {

    var presenter: DetailMoviePresenter? = null
    var movie: DescriptionMovieModel? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        //init
        presenter = DetailMoviePresenter()
        movie = intent.getParcelableExtra(ConstantTemplate.ARG_MOVIE)

        onAttachView()
        presenter?.getDetailMovie(movie?.id, "id")

        setDetailMovie()
    }

    private fun setDetailMovie() {
        Glide.with(this)
            .load(BuildConfig.BASEURLIMAGE + "${movie?.posterPath}")
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dma_iv_poster)

        val backdrop = movie?.backdropPath ?: movie?.posterPath
        Glide.with(this)
            .load(BuildConfig.BASEURLIMAGE + "$backdrop")
            .placeholder(R.drawable.ic_picture_placeholder)
            .error(R.drawable.ic_picture_failed)
            .into(dma_iv_backdrop)

        dma_viewgroup_adult.visibility =
            if (movie?.adult == true) View.VISIBLE else View.INVISIBLE
        dma_tv_overview.text =
            if (movie?.overview == null || movie?.overview == "") resources.getString(R.string.string_overview_has_not_exist) else movie?.overview
        dma_tv_title.text = movie?.originalTitle.toString()
        dma_tv_year.text = presenter?.getYearFromDate(movie?.releaseDate.toString())
        dma_tv_rating.text = movie?.voteAverage.toString()
        dma_tv_popularity.text =
            if (movie?.popularity == null) "-" else String.format("%.1f", movie?.popularity)
        dma_tv_vote_count.text =
            if (movie?.voteCount == null) "-" else movie?.voteCount.toString()
        dma_tv_duration.text = presenter?.convertDuration(movie?.runtime)
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showErrorMessage(message: String?) {
        toast("Error because $message")
        Log.e("DETAILMOVIE", message)
    }

    override fun onShowDetailMovie(detailMovieModel: DescriptionMovieModel?) {
        movie = detailMovieModel
        setDetailMovie()
    }

    override fun onAttachView() {
        presenter?.onAttach(this)
    }

    override fun onDetachView() {
        presenter?.onDetach()
    }
}
