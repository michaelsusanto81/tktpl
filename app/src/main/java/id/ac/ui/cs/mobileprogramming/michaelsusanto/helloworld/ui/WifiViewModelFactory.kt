package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WifiViewModelFactory(private val context: Context): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WifiViewModel::class.java)) {
            return WifiViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}