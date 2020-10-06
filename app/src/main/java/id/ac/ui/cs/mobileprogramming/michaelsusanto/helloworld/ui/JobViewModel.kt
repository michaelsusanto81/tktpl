package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.JobModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class JobViewModel: ViewModel() {
    val jobsLiveData = MutableLiveData<List<JobModel>>()
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    fun fetchDataFromAPI() {
        coroutineScope.launch {
            try {
                val jobs = mutableListOf<JobModel>(
                    JobModel(
                        id = 1,
                        name = "Software Engineering",
                        employer = "Google",
                        description = "Software Engineering Internship details . . ."
                    ),
                    JobModel(
                        id = 2,
                        name = "Data Science",
                        employer = "Amazon",
                        description = "Data Science Internship details . . ."
                    ),
                    JobModel(
                        id = 3,
                        name = "Product Management",
                        employer = "Google",
                        description = "Product Management Internship details . . ."
                    ),
                    JobModel(
                        id = 4,
                        name = "Software Engineering",
                        employer = "Facebook",
                        description = "Software Engineering Internship details . . ."
                    ),
                    JobModel(
                        id = 5,
                        name = "Software Engineering",
                        employer = "Microsoft",
                        description = "Software Engineering Internship details . . ."
                    ),
                    JobModel(
                        id = 6,
                        name = "Data Science",
                        employer = "Gojek",
                        description = "Software Engineering Internship details . . ."
                    ),
                )

                jobsLiveData.value = jobs
            }

            catch (e: Exception) {
                Log.i("Error Message:", e.message!!)
            }
        }

    }
}