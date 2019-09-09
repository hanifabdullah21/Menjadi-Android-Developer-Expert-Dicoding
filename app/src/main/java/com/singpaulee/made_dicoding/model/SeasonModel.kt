package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class SeasonModel(

    @field:SerializedName("air_date") val air_date: String? = null,
    @field:SerializedName("episode_count") val episode_count: Int? = null,
    @field:SerializedName("id") val id: Int? = null,
    @field:SerializedName("name") val name: String? = null,
    @field:SerializedName("overview") val overview: String? = null,
    @field:SerializedName("poster_path") val poster_path: String? = null,
    @field:SerializedName("season_number") val season_number: Int? = null

)