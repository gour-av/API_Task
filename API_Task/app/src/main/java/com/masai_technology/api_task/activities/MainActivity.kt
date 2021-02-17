package com.masai_technology.api_task.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai_technology.api_task.adapter.LoadAdapter
import com.masai_technology.api_task.R
import com.masai_technology.api_task.model.MessageItem
import com.masai_technology.api_task.ui.LoadUIModel
import com.masai_technology.api_task.viewmodel.LoadViewModel
import kotlinx.android.synthetic.main.activity_main.*
/**
 * this Activity makes an Api call and populates the result in a recycler view .
 *
 */
class MainActivity : AppCompatActivity() {
    private lateinit var userViewModel: LoadViewModel
    private lateinit var userAdapter: LoadAdapter
    private val dataModelList = emptyList<MessageItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userViewModel = ViewModelProvider(this).get(LoadViewModel::class.java)
        setRecyclerAdapter()
        observeLiveData()
        flProgressBar.visibility = View.VISIBLE
        userViewModel.callAPI()
    }

    /**
     *
     * In this we are observing the data changes with the help of live data
     */
    private fun observeLiveData() {
        userViewModel.liveData.observe(this, Observer {
            when (it) {
                is LoadUIModel.Success -> {
                    userAdapter.updateList(it.dataModelList)
                    flProgressBar.visibility = View.GONE
                }
                is LoadUIModel.Failure -> {
                    Toast.makeText(
                        this@MainActivity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                    flProgressBar.visibility = View.GONE
                }
            }
        })
    }

    /***
     * Overhere we are setting up the recycler adapter
     */
    private fun setRecyclerAdapter() {
        userAdapter = LoadAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            this.layoutManager = layoutManager
            adapter = userAdapter
        }
    }
}