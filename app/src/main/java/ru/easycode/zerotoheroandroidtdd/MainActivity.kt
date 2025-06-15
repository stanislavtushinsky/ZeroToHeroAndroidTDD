package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var state: UiState
    private val count = Count.Base(2, 4, 0)
    private lateinit var textView: TextView
    private lateinit var incButton: Button
    private lateinit var decButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.countTextView)
        incButton = findViewById<Button>(R.id.incrementButton)
        decButton = findViewById<Button>(R.id.decrementButton)


        decButton.setOnClickListener {
            state = count.decrement(textView.text.toString())
            state.apply(textView, decButton, incButton)
        }

        incButton.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply(textView, decButton, incButton)
        }

        if (savedInstanceState == null) {
            state = count.initial(textView.text.toString())
            state.apply(textView, decButton, incButton)
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = count.initial(textView.text.toString())
        state.apply(textView, decButton, incButton)
    }
}