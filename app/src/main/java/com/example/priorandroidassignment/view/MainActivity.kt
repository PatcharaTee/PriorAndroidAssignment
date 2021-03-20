package com.example.priorandroidassignment.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.priorandroidassignment.R
import com.example.priorandroidassignment.adapter.JobAdapter
import com.example.priorandroidassignment.model.Job
import com.example.priorandroidassignment.route.RequestInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set up recyclerview
        val jobListRV: RecyclerView = findViewById(R.id.JobListRV)
        jobListRV.layoutManager = LinearLayoutManager(this)
        //set up retrofit
        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl("https://dev.priorsolution.co.th/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        //send request to url and set adapter to recyclerview
        val requestInterface: RequestInterface = retrofit.create(RequestInterface::class.java)
        val postCall: Call<List<Job>> = requestInterface.getJobList()
        postCall.enqueue(object : Callback<List<Job>> {
            @SuppressLint("ShowToast")
            override fun onResponse(call: Call<List<Job>>, response: Response<List<Job>>) {
                if (!response.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "Code: " + response.code(),
                        Toast.LENGTH_SHORT
                    )
                } else {
                    val jobList: List<Job> = response.body()!!
                    jobListRV.adapter = JobAdapter(jobList, this@MainActivity)
                }
            }

            @SuppressLint("ShowToast")
            override fun onFailure(call: Call<List<Job>>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "no response",
                    Toast.LENGTH_SHORT
                )
            }
        })
    }
}