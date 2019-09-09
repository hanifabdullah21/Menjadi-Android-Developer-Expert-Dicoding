package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class CreatedByModel(

    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("credit_id")
    val credit_id: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("gender")
    val gender: Int? = null,
    @field:SerializedName("profile_path")
    val profile_path: String? = null
)