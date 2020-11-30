package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.repository

import android.content.Context
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.api.ApiFactory
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.api.WifiApi
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.Wifi

class WifiRepository(context: Context) {
    private var api: WifiApi = ApiFactory.getWifiApi(context)

    suspend fun postWifiList(wifiList: List<Wifi>) {
        api.postWifiList(wifiList)
    }
}