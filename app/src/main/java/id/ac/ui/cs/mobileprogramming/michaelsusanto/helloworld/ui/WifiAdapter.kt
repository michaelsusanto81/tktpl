package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.R
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.data.model.Wifi
import kotlinx.android.synthetic.main.card_wifi.view.*

class WifiAdapter(private val wifiList: List<Wifi>): RecyclerView.Adapter<WifiAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WifiAdapter.Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_wifi, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WifiAdapter.Holder, position: Int) {
        holder.view.ssid.text = wifiList[position].ssid
        holder.view.bssid.text = wifiList[position].bssid
        holder.view.frequency.text = wifiList[position].frequency.toString()
    }

    override fun getItemCount(): Int = wifiList.size

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view)
}