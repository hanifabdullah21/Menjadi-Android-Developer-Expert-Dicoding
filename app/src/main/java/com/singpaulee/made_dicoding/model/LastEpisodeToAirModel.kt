package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class LastEpisodeToAirModel(

    @field:SerializedName("air_date")
    val air_date: String? = null,
    @field:SerializedName("episode_number")
    val episode_number: Int? = null,
    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("overview")
    val overview: String? = null,
    @field:SerializedName("production_code")
    val production_code: Int? = null,
    @field:SerializedName("season_number")
    val season_number: Int? = null,
    @field:SerializedName("show_id")
    val show_id: Int? = null,
    @field:SerializedName("still_path")
    val still_path: String? = null,
    @field:SerializedName("vote_average")
    val vote_average: Double? = null,
    @field:SerializedName("vote_count")
    val vote_count: Int? = null

)