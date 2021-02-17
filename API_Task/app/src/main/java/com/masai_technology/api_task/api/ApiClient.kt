package com.masai_technology.api_task.api

import com.masai_technology.api_task.model.ResponseLoad
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("/get_payload/")
    fun getUsers(): Call<ResponseLoad>
}