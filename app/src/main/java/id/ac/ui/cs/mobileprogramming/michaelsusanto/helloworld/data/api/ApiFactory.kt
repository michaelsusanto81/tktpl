package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.api

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiFactory {
    private lateinit var wifiApi: WifiApi
    private lateinit var retrofit: Retrofit

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .callTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    private fun getRetrofit(context: Context): Retrofit {
        if(!::retrofit.isInitialized) {
            retrofit = Retrofit.Builder()
                .client(okHttpClient())
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(Constants.API_URL)
                .build()
        }
        return retrofit
    }

    fun getWifiApi(context: Context): WifiApi {
        if(!::wifiApi.isInitialized) {
            wifiApi = getRetrofit(context).create(WifiApi::class.java)
        }
        return wifiApi
    }
}