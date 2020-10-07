package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.JobModel
import kotlinx.android.synthetic.main.card_job.view.*

class JobAdapter(private val jobs: ArrayList<JobModel>, private val listener: OnJobClickListener) : RecyclerView.Adapter<JobAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobAdapter.Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_job, parent, false)
        )
    }

    override fun onBindViewHolder(holder: JobAdapter.Holder, position: Int) {
        holder.view.job_title.text = jobs[position].name
        holder.view.job_employer.text = jobs[position].employer
    }

    override fun getItemCount(): Int = jobs.size

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                val position = adapterPosition
                val job = jobs[position]
                listener.getClickedJob(job)
            }
        }
    }
}