package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld

import android.annotation.SuppressLint
import android.content.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val br: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            updateView(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonStart.setOnClickListener {
            startService(Intent(this, StopwatchService::class.java))
        }

        binding.buttonStop.setOnClickListener {
            stopService(Intent(this, StopwatchService::class.java))
            binding.textViewTimer.setText(R.string.stopwatch_time)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(br, IntentFilter(StopwatchService.STOPWATCH_BR))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(br)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopService(Intent(this, StopwatchService::class.java))
    }

    override fun onBackPressed() {
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Exit")
            .setMessage("Are you sure? Currently running stopwatch will be lost.")
            .setPositiveButton("Yes") { _, _ -> finish() }
            .setNegativeButton("No") { _, _ -> }
            .create()
        dialog.show()
    }

    @SuppressLint("SetTextI18n")
    private fun updateView(intent: Intent?) {
        if(intent?.extras != null) {
            val hours: String = intent.getStringExtra("hours")!!
            val minutes: String = intent.getStringExtra("minutes")!!
            val seconds: String = intent.getStringExtra("seconds")!!
            binding.textViewTimer.text = "$hours:$minutes:$seconds"
        }
    }
}