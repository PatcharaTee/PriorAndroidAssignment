package com.example.priorandroidassignment.route

import com.example.priorandroidassignment.model.Job
import retrofit2.Call
import retrofit2.http.GET

interface RequestInterface {

    @GET("test/job_list.json")
    fun getJobList(): Call<List<Job>>
}