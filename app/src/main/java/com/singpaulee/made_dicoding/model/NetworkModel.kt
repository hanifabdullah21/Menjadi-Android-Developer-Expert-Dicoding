package com.singpaulee.made_dicoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NetworkModel(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("logo_path")
    val logo_path: String? = null,

    @field:SerializedName("origin_country")
    val origin_country: String? = null
) : Parcelable