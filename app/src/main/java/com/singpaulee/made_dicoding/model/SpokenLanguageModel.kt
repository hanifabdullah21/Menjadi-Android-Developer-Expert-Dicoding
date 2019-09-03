package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class SpokenLanguageModel(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("iso_639_1")
    val id: String? = null
)