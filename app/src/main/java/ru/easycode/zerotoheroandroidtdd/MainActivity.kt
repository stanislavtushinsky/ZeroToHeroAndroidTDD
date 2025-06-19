package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.actionButton)
        val textView: TextView = findViewById<TextView>(R.id.titleTextView)
        val progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)
        val viewModel = (application as MyApplication).provideViewModel()

        button.setOnClickListener {
            viewModel.load()
        }

        viewModel.getLiveData().observe(this) {
            it.apply(textView, progressBar, button)
        }

    }
}