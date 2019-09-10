package com.singpaulee.made_dicoding.connection

import com.singpaulee.made_dicoding.model.DescriptionMovieModel
import com.singpaulee.made_dicoding.model.DescriptionTvModel
import com.singpaulee.made_dicoding.model.ResponseListMovieModel
import com.singpaulee.made_dicoding.model.ResponseListTvModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkInterface {

    @GET("movie/now_playing")
    fun getListMovieNowPlaying(
        @Query("api_key") apiKey: String,
        @Query("region") region: String,
        @Query("language") language: String
    ): Observable<ResponseListMovieModel?>

    @GET("movie/{id}")
    fun getDetailMovie(
        @Path("id") movieId: Int?,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<DescriptionMovieModel?>

    @GET("tv/airing_today")
    fun getListTvAiringToday(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<ResponseListTvModel?>

    @GET("tv/{id}")
    fun getDetailTv(
        @Path("id") tvId: Int?,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Observable<DescriptionTvModel?>
}