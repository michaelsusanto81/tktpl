package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.JobModel

interface OnJobClickListener {
    fun getClickedJob(job: JobModel)
}