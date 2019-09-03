package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class ProductionCountryModel(

	@field:SerializedName("iso_3166_1")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)