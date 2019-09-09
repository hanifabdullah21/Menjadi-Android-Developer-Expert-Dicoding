package com.singpaulee.made_dicoding.connection

import android.content.Context
import com.google.gson.GsonBuilder
import com.singpaulee.made_dicoding.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkConfig {

    fun retrofitConfig(): Retrofit {

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASEURL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient())
            .build()
    }

}