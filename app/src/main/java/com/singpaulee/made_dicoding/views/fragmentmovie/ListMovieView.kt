package com.singpaulee.made_dicoding.views.fragmentmovie

import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import com.singpaulee.made_dicoding.model.DescriptionTvModel
import com.singpaulee.made_dicoding.views.base.View

interface ListMovieView : View {

    fun showLoading()

    fun hideLoading()

    fun showErrorMessage(message: String?)

    fun onShowListMovie(listMovie: ArrayList<DescriptionMovieModel>?)

    fun onShowListTv(listTv: ArrayList<DescriptionTvModel>?)

}