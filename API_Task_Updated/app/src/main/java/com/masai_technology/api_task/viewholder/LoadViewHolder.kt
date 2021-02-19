package com.masai_technology.api_task.viewholder

import android.view.View
import android.widget.Switch
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai_technology.api_task.R
import com.masai_technology.api_task.model.MessageItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class LoadViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(messageItem: MessageItem) {
        view.apply {
            fun main(args: Array<String>) {
                val array1 = arrayOf(R.drawable.ic_eggs,R.drawable.ic_groceries,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background)
                for(item in array1.indices) {
                    println("marks[$item]: " + array1[item])

                                //img_image.setImageResource(array1[item])
                    img_image.setImageDrawable(resources.getDrawable(array1[item]))
                 }
                }



            // Glide.with(img_image).load(messageItem.filename).into(img_image)
          tv_title.text = messageItem.title
            tv_type.text = messageItem.type
           tv_description.text = messageItem.description
            tv_price.text = messageItem.price.toString()

        }
    }
}