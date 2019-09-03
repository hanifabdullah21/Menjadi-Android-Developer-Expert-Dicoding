package com.singpaulee.made_dicoding.model

import com.google.gson.annotations.SerializedName

data class ProductionCompanyModel(

	@field:SerializedName("logo_path")
	val logoPath: Any? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("origin_country")
	val originCountry: String? = null
)