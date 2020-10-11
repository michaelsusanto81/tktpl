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
    val clickedJob = MutableLiveData<JobModel>()
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
                        description = "We're looking for engineers who bring fresh ideas from all areas, " +
                                "including information retrieval, distributed computing, " +
                                "large-scale system design, networking and data storage, security, " +
                                "artificial intelligence, natural language processing, " +
                                "UI design and mobile; the list goes on and is growing every day."
                    ),
                    JobModel(
                        id = 2,
                        name = "Data Science",
                        employer = "Amazon",
                        description = "The WW Revenue Operation and Data Analytics team is looking " +
                                "for a Data Scientist Leader to manage our science team. " +
                                "This leader will work closely with business stakeholders to automate " +
                                "recommendations by creating various tools and machine-learning models " +
                                "to answer complex business questions and provide insights."
                    ),
                    JobModel(
                        id = 3,
                        name = "Product Management",
                        employer = "Google",
                        description = "As part of the Product Management team, you bridge technical " +
                                "and business worlds as you design technologies with creative and " +
                                "prolific engineers and then zoom out to lead matrix teams such as " +
                                "Sales, Marketing and Finance, to name a few."
                    ),
                    JobModel(
                        id = 4,
                        name = "Software Engineering",
                        employer = "Facebook",
                        description = "Software engineers on these teams use the latest technology " +
                                "to build new features and improve existing components across all of " +
                                "Facebook's apps and services. They also partner closely with " +
                                "product teams to define feature specifications and build " +
                                "the next generation of products from Facebook."
                    ),
                    JobModel(
                        id = 5,
                        name = "Software Engineering",
                        employer = "Microsoft",
                        description = "In the CSI Drivers & Enablement development team, you will " +
                                "design and implement software components to enable and optimize " +
                                "the Azure fleet. As part of a team, you help enable specialized " +
                                "storage and networking device hardware, and customized offloading " +
                                "hardware in our servers."
                    ),
                    JobModel(
                        id = 6,
                        name = "Data Science",
                        employer = "Gojek",
                        description = "GOJEK’s data scientists solve some of the company’s most difficult " +
                                "and crucial problems. From matching drivers and customers to " +
                                "personalizing your GO-FOOD search, each project they do impact millions of lives!"
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