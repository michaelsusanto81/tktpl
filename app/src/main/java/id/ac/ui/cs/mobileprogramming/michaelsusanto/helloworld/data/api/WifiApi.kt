package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.api

import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.Wifi
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface WifiApi {

    @Headers("Content-Type: application/json")
    @POST("/")
    suspend fun postWifiList(@Body wifiList: List<Wifi>)
}