package com.singpaulee.made_dicoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BelongsToCollectionModel(

    @field:SerializedName("unknown")
    val unknown: String? = null

) : Parcelable