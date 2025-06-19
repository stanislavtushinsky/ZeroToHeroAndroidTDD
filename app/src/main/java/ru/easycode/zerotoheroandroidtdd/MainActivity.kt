package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.actionButton)
        val textView: TextView = findViewById<TextView>(R.id.titleTextView)
        val progressBar: ProgressBar = findViewById<ProgressBar>(R.id.progressBar)

        viewModel = (application as MyApp).provideViewModel()

        button.setOnClickListener {
            viewModel.load()
        }

        viewModel.getLiveData().observe(this) {
            it.apply(textView, button, progressBar)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapperImpl(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapperImpl(savedInstanceState))
    }
}