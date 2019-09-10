package com.singpaulee.made_dicoding.views.detailtv

import com.singpaulee.made_dicoding.model.DescriptionTvModel
import com.singpaulee.made_dicoding.views.base.View

interface DetailTvView : View {

    fun showLoading()

    fun hideLoading()

    fun showErrorMessage(message: String?)

    fun onShowDetailTv(detailTvModel: DescriptionTvModel?)

}