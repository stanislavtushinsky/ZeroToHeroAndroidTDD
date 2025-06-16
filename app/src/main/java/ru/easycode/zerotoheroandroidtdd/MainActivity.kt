package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var progressBar: ProgressBar
    lateinit var textView: TextView
    private val viewModel = MainViewModel(LiveDataWrapperImpl(), RepositoryImpl())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.actionButton)
        textView = findViewById<TextView>(R.id.titleTextView)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)

        button.setOnClickListener {
            viewModel.load()
        }

        viewModel.getLiveData().observe(this) { uiState ->
            uiState.apply(textView, button, progressBar)
        }
    }
}