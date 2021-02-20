package com.wisnuwahyudi.aplikasikuis.kategorisoal.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseCategory(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

@Parcelize
data class DataItem(

	@field:SerializedName("ID")
	val iD: String? = null,

	@field:SerializedName("Image")
	val image: String? = null,

	@field:SerializedName("Name")
	val name: String? = null
) : Parcelable
