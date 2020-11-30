package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.PermissionChecker
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: WifiViewModel
    private lateinit var viewModelFactory: WifiViewModelFactory
    private val PERMISSION_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)

        viewModelFactory = WifiViewModelFactory(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(WifiViewModel::class.java)

        checkPermissions()

        fetchData()
        binding.swipeRefresh.setOnRefreshListener(this)
        binding.recView.layoutManager = LinearLayoutManager(this)
        binding.recView.adapter = WifiAdapter(ArrayList())

        binding.fab.setOnClickListener {
        }
    }

    private fun checkPermissions() {
        if (
            PermissionChecker.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) == PermissionChecker.PERMISSION_DENIED ||
            PermissionChecker.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PermissionChecker.PERMISSION_DENIED
        ) {
            val permissions = arrayOf(
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            requestPermissions(permissions, PERMISSION_CODE)
        }
    }

    private fun fetchData() {
        binding.swipeRefresh.isRefreshing = true
        viewModel.getWifiList()
        viewModel.liveData.observe(this, Observer {
            val wifiList = viewModel.liveData.value
            binding.recView.adapter = WifiAdapter(wifiList as ArrayList)
        })
        binding.swipeRefresh.isRefreshing = false
    }

    override fun onRefresh() {
        fetchData()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.swipeRefresh.setOnRefreshListener(null)
    }
}