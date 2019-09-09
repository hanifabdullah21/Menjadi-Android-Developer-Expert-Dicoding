package com.singpaulee.made_dicoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DescriptionMovieModel(

    @field:SerializedName("status_message")
    val statusMessage: String? = null,

    @field:SerializedName("success")
    val success: Boolean? = null,

    @field:SerializedName("status_code")
    val statusCode: Int? = null,

    @field:SerializedName("original_language")
    val originalLanguage: String? = null,

    @field:SerializedName("imdb_id")
    val imdbId: String? = null,

    @field:SerializedName("video")
    val video: Boolean? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @field:SerializedName("revenue")
    val revenue: Int? = null,

    @field:SerializedName("genres")
    val genres: MutableList<GenreMovieModel?>? = null,

    @field:SerializedName("popularity")
    val popularity: Double? = null,

    @field:SerializedName("production_countries")
    val productionCountries: MutableList<ProductionCountryModel?>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("vote_count")
    val voteCount: Int? = null,

    @field:SerializedName("budget")
    val budget: Int? = null,

    @field:SerializedName("overview")
    val overview: String? = null,

    @field:SerializedName("original_title")
    val originalTitle: String? = null,

    @field:SerializedName("runtime")
    val runtime: Int? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    @field:SerializedName("spoken_languages")
    val spokenLanguages: MutableList<SpokenLanguageModel?>? = null,

    @field:SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanyModel?>? = null,

    @field:SerializedName("release_date")
    val releaseDate: String? = null,

    @field:SerializedName("vote_average")
    val voteAverage: Double? = null,

    @field:SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollectionModel? = null,

    @field:SerializedName("tagline")
    val tagline: String? = null,

    @field:SerializedName("adult")
    val adult: Boolean? = null,

    @field:SerializedName("homepage")
    val homepage: String? = null,

    @field:SerializedName("status")
    val status: String? = null
) : Parcelable