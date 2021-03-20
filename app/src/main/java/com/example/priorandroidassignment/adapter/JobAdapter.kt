package com.example.priorandroidassignment.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.priorandroidassignment.R
import com.example.priorandroidassignment.model.Job
import com.example.priorandroidassignment.view.JobDetailActivity

class JobAdapter(private var jobList: List<Job>, private var context: Context) :
    RecyclerView.Adapter<JobAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_job, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.jobNoTV.text = "Job No " + jobList[position].jobNo
        holder.truckLicenseTV.text = "Truck License " + jobList[position].truckLicense
        holder.itemView.setOnClickListener {
            val intent = Intent(context, JobDetailActivity::class.java).apply {
                putExtra("job_detail", jobList[position])
            }
            startActivity(context, intent, null)
        }
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var jobNoTV: TextView = itemView.findViewById(R.id.jobNoTV)
        var truckLicenseTV: TextView = itemView.findViewById(R.id.truckLicenseTV)
    }
}