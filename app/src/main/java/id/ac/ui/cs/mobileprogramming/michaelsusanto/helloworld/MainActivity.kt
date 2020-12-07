package id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import id.ac.ui.cs.mobileprogramming.michaelsusanto.helloworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        System.loadLibrary("native-sum-util")

        binding.btnAdd.setOnClickListener { add() }
    }

    private fun add() {
        val firstNum = binding.firstNumEdit.text.toString().toInt()
        val secondNum = binding.secondNumEdit.text.toString().toInt()
        val result = nativeSum(firstNum, secondNum)
        val toast = Toast.makeText(this, "Result is: $result", Toast.LENGTH_LONG)
        toast.show()
    }

    external fun nativeSum(firstNum: Int, secondNum: Int): Int
}