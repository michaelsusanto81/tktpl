package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.JobModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: JobViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(JobViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.clickedJob.observe(viewLifecycleOwner, Observer {
            updateUI(it)
        })

        binding.buttonApply.setOnClickListener {
            applyJob()
        }
    }

    private fun updateUI(job: JobModel) {
        binding.jobTitle.text = job.name
        binding.jobEmployer.text = job.employer
        binding.jobDescription.text = job.description
    }

    private fun applyJob() {
        val toast = Toast.makeText(context, "Applied!", Toast.LENGTH_LONG)
        toast.show()
    }
}