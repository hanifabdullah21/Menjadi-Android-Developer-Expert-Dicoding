package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class DateModel (

    @field:SerializedName("maximum")
    val maximum: String? = null,

    @field:SerializedName("minimum")
    val minimum: String? = null

)