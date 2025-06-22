package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.actionButton)
        val editText = findViewById<TextInputEditText>(R.id.inputEditText)
        val textView = findViewById<TextView>(R.id.titleTextView)

        button.setOnClickListener {
            editText.setText(getText(R.string.empty))
            textView.text = getText(R.string.new_text)
        }
    }
}