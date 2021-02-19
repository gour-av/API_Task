package com.masai_technology.api_task.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masai_technology.api_task.model.MessageItem
import com.masai_technology.api_task.model.ResponseLoad
import com.masai_technology.api_task.repository.LoadRepository
import com.masai_technology.api_task.ui.LoadUIModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
/***
 * This is the viewmodel class where we are getting the response from the api using retrofit
 */
class LoadViewModel :ViewModel(), Callback<ResponseLoad> {
    private val repository = LoadRepository(this)

    private val mutableLiveData = MutableLiveData<LoadUIModel>()
    val liveData: LiveData<LoadUIModel> = mutableLiveData

    override fun onResponse(call: Call<ResponseLoad>, response: Response<ResponseLoad>) {
        response.body()?.let {
            mutableLiveData.value = LoadUIModel.Success(it.message as List<MessageItem>)
        }
    }

    override fun onFailure(call: Call<ResponseLoad>, t: Throwable) {
        mutableLiveData.value = LoadUIModel.Failure(t.message!!)
    }
    fun callAPI() {
        repository.getListOfGroceries()
    }
}