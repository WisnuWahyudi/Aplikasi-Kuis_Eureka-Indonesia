package com.wisnuwahyudi.aplikasikuis.tampilankuis.model

import com.google.gson.annotations.SerializedName

data class ResponseSoalSoal(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("isSuccess")
	val isSuccess: Boolean? = null
)

data class DataItem(

	@field:SerializedName("IDQ")
	val iDQ: String? = null,

	@field:SerializedName("answerC")
	val answerC: String? = null,

	@field:SerializedName("questionImage")
	val questionImage: String? = null,

	@field:SerializedName("answerB")
	val answerB: String? = null,

	@field:SerializedName("answerD")
	val answerD: String? = null,

	@field:SerializedName("correctAnswer")
	val correctAnswer: String? = null,

	@field:SerializedName("questionText")
	val questionText: String? = null,

	@field:SerializedName("answerA")
	val answerA: String? = null
)
