package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.ActivityMainBinding
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.ui.JobViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: JobViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(JobViewModel::class.java)
        setSupportActionBar(binding.toolbar)
    }
}