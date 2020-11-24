package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.FragmentWifiBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class WifiFragment : Fragment() {

    private lateinit var binding: FragmentWifiBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wifi, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}