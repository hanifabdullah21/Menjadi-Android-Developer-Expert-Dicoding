package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName
import com.singpaulee.made_dicoding.model.DateModel
import com.singpaulee.made_dicoding.model.DescriptionMovieModel

data class ResponseListMovieModel(

    @field:SerializedName("status_message")
    val statusMessage: String? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("status_code")
    val statusCode: Int? = null,

    @field:SerializedName("results")
    val result: ArrayList<DescriptionMovieModel>? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("total_results")
    val totalResults: Int? = null,

    @field:SerializedName("dates")
    val dates: DateModel? = null,

    @field:SerializedName("total_pages")
    val totalPages: Int? = null

)

