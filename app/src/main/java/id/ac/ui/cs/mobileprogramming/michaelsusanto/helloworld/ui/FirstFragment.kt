package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.JobModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.FragmentFirstBinding
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util.JobAdapter
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util.OnJobClickListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), OnJobClickListener {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: JobViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(JobViewModel::class.java)

        initRecView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateRecView()
    }

    private fun initRecView() {
        binding.mRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mRecyclerView.adapter = JobAdapter(ArrayList(), this)
        viewModel.fetchDataFromAPI()
    }

    private fun updateRecView() {
        viewModel.jobsLiveData.observe(viewLifecycleOwner, Observer {
            binding.mRecyclerView.adapter = JobAdapter(viewModel.jobsLiveData.value as ArrayList<JobModel>, this)
        })
    }

    override fun getClickedJob(job: JobModel) {
        viewModel.clickedJob.value = job
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}