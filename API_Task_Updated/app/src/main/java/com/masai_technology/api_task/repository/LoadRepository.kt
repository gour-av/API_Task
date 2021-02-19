package com.masai_technology.api_task.repository

import com.masai_technology.api_task.api.ApiClient
import com.masai_technology.api_task.api.Network
import com.masai_technology.api_task.model.ResponseLoad
import retrofit2.Callback
/***
 * This is the repository class through which we are getting the callbacks
 */
class LoadRepository(private val callback: Callback<ResponseLoad>) {

    fun getListOfGroceries(){
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getUsers()
        /***
        Once the response is fetched, navigate the user back to view model as this callback is being implemented
        in the Viewmodel class
         */
        call.enqueue(callback)
    }
}