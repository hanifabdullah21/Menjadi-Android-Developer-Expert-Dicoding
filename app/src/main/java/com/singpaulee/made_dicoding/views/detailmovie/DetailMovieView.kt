package com.singpaulee.made_dicoding.views.detailmovie

import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import com.singpaulee.made_dicoding.views.base.View


interface DetailMovieView : View {

    fun showLoading()

    fun hideLoading()

    fun showErrorMessage(message: String?)

    fun onShowDetailMovie(detailMovieModel : DescriptionMovieModel?)
}