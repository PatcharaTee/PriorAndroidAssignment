package com.example.priorandroidassignment.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.priorandroidassignment.R
import com.example.priorandroidassignment.model.Job
import java.text.SimpleDateFormat
import java.util.*

class JobDetailActivity : AppCompatActivity() {

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_detail)

        //Get data from intend
        val jobDetail: Job = intent.getSerializableExtra("job_detail") as Job

        //Inflate from layout
        val backBT: Button = findViewById(R.id.backBT)
        val jobDetailTV: TextView = findViewById(R.id.jobDetailTV)

        //Format date
        val routeDT: String =
            SimpleDateFormat("d MMM yyyy").format(SimpleDateFormat("yyyy/M/d").parse(jobDetail.routeDt) as Date)
        val arrivalDT: String =
            SimpleDateFormat("d MMM yyyy HH:mm").format(
                SimpleDateFormat("yyyy/M/d HH:mm").parse(
                    jobDetail.arrivalDt
                ) as Date
            )
        val departureDT: String =
            SimpleDateFormat("d MMM yyyy HH:mm").format(
                SimpleDateFormat("yyyy/M/d HH:mm").parse(
                    jobDetail.departureDt
                ) as Date
            )

        //string to text view
        val jobDetailSTR: String = "Job No " + jobDetail.jobNo + "\n" +
                "Truck License " + jobDetail.truckLicense + "\n" +
                "Province " + jobDetail.province + "\n" +
                "Truck Type " + jobDetail.truckType + "\n" +
                "Route Date " + routeDT + "\n" +
                "routeCd " + jobDetail.routeCd + "\n" +
                "Logistic Point CD " + jobDetail.logisticPointCd + "\n" +
                "Arrival Date " + arrivalDT + "\n" +
                "Departure Date " + departureDT + "\n"
        jobDetailTV.text = jobDetailSTR

        //Back Button
        backBT.setOnClickListener {
            finish()
        }
    }
}