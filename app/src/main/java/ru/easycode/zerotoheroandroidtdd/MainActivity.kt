package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    //lateinit var state: State

    private val count = Count.Base(2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button>(R.id.incrementButton)
        textView = findViewById<TextView>(R.id.countTextView)

        button.setOnClickListener {
            var textValue = textView.text.toString().trim()
            textView.text = count.increment(textValue)
            //state = State.Saved(textView.text.toString())
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //  outState.putSerializable("state", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
//        state = savedInstanceState.getSerializable("state") as State

    }
}

// в идеале допилить через стейты

interface State : Serializable {
    fun save(text: Count.Base)

    class Saved(val value: String) : State {
        override fun save(text: Count.Base) = Unit
    }
}