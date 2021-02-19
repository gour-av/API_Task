package com.masai_technology.api_task.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class ResponseLoad(

	@field:SerializedName("message")
	val message: List<MessageItem?>? = null
)