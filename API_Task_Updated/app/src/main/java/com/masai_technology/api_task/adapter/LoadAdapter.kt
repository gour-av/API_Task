package com.masai_technology.api_task.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai_technology.api_task.R
import com.masai_technology.api_task.model.MessageItem
import com.masai_technology.api_task.viewholder.LoadViewHolder

class LoadAdapter(private var dataModelList: List<MessageItem>) : RecyclerView.Adapter<LoadViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoadViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return LoadViewHolder(view)
    }

    override fun onBindViewHolder(holder: LoadViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }

    fun updateList(modelList: List<MessageItem>) {
        dataModelList = modelList
        notifyDataSetChanged()
    }
}