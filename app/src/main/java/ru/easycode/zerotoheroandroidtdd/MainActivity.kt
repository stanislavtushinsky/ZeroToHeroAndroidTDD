package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.postDelayed

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        textView = findViewById<TextView>(R.id.titleTextView)
        button = findViewById<Button>(R.id.actionButton)

        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            button.postDelayed(3500) {
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
                button.isEnabled = true
            }
        }
    }
}