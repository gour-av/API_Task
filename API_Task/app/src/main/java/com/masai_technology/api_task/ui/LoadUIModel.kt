package com.masai_technology.api_task.ui

import com.masai_technology.api_task.model.MessageItem

sealed class LoadUIModel {

     data class Success(val dataModelList: List<MessageItem>) : LoadUIModel()

     data class Failure(val error: String) : LoadUIModel()
}