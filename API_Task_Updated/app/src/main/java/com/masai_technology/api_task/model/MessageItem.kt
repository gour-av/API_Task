package com.masai_technology.api_task.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class MessageItem(

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("filename")
	val filename: String? = null,

	@field:SerializedName("height")
	val height: Int? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("price")
	val price: Any? = null,

	@field:SerializedName("rating")
	val rating: Int? = null
)