package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class GenreMovieModel(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)