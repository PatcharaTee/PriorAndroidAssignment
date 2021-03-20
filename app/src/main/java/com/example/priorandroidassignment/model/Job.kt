package com.example.priorandroidassignment.model

import java.io.Serializable

data class Job(
    val jobNo: String,
    val truckLicense: String,
    val province: String,
    val truckType: String,
    val routeDt: String,
    val routeCd: String,
    val logisticPointCd: String,
    val arrivalDt: String,
    val departureDt: String
) : Serializable
