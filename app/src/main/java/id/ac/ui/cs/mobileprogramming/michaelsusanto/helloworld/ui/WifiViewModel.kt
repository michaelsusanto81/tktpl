package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.Wifi

class WifiViewModel(private val context: Context): ViewModel() {
    private val wifiManager: WifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
    val liveData: MutableLiveData<List<Wifi>> = MutableLiveData()

    private val wifiScanReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val success = intent.getBooleanExtra(WifiManager.EXTRA_RESULTS_UPDATED, false)
            if (success) {
                scanSuccess()
            } else {
                scanFailure()
            }
            context.unregisterReceiver(this)
        }
    }

    private fun scanSuccess() {
        val results = wifiManager.scanResults
        val wifiList = results.map {
            Wifi(it.SSID, it.BSSID, it.frequency)
        }
        liveData.value = wifiList
        Log.d("SCAN SUCCESS", results.toString())
    }

    private fun scanFailure() {
        // handle failure: new scan did NOT succeed
        // consider using old scan results: these are the OLD results!
        val results = wifiManager.scanResults
        val wifiList = results.map {
            Wifi(it.SSID, it.BSSID, it.frequency)
        }
        liveData.value = wifiList
        Log.d("SCAN FAILED", results.toString())
    }

    fun getWifiList() {
        context.registerReceiver(
            wifiScanReceiver,
            IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION)
        )
        wifiManager.startScan()
    }
}