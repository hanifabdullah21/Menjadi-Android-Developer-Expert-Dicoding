package com.singpaulee.made_dicoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DescriptionTvModel(
    @field:SerializedName("status_message")
    val statusMessage: String? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("status_code")
    val statusCode: Int? = null,

    @field:SerializedName("backdrop_path")
    val backdrop_path: String? = null,

//    @field:SerializedName("created_by")
//    val created_by: List<CreatedByModel>? = null,

//    @field:SerializedName("episode_run_time")
//    val episode_run_time: List<Int>? = null,

    @field:SerializedName("first_air_date")
    val first_air_date: String? = null,

//    @field:SerializedName("genres")
//    val genres: List<GenreMovieModel>? = null,

//    @field:SerializedName("homepage")
//    val homepage: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

//    @field:SerializedName("in_production")
//    val in_production: Boolean? = null,

//    @field:SerializedName("languages")
//    val languages: List<String>? = null,

    @field:SerializedName("last_air_date")
    val last_air_date: String? = null,

    @field:SerializedName("last_episode_to_air")
    val last_episode_to_air: LastEpisodeToAirModel? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("next_episode_to_air")
    val next_episode_to_air: LastEpisodeToAirModel? = null,

//    @field:SerializedName("networks")
//    val networks: List<NetworkModel>? = null,

//    @field:SerializedName("number_of_episodes")
//    val number_of_episodes: Int? = null,

//    @field:SerializedName("number_of_seasons")
//    val number_of_seasons: Int? = null,

//    @field:SerializedName("origin_country")
//    val origin_country: List<String>? = null,

//    @field:SerializedName("original_language")
//    val original_language: String? = null,

    @field:SerializedName("original_name")
    val original_name: String? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null,

    @field:SerializedName("poster_path")
    val poster_path: String? = null,

//    @field:SerializedName("production_companies")
//    val production_companies: List<ProductionCompanyModel>? = null,

//    @field:SerializedName("seasons")
//    val seasons: List<SeasonModel>? = null,

//    @field:SerializedName("status")
//    val status: String? = null,

//    @field:SerializedName("type")
//    val type: String? = null,

    @field:SerializedName("vote_average")
    val vote_average: Double? = null,

    @field:SerializedName("vote_count")
    val vote_count: Int? = null

) : Parcelable