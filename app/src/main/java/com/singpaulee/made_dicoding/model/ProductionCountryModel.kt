package com.singpaulee.made_dicoding.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductionCountryModel(

	@field:SerializedName("iso_3166_1")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable