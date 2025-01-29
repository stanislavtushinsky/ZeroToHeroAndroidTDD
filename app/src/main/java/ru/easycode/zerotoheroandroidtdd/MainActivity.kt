package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var state: State
    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.removeButton)
        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            state = State.Deleted
            state.apply(linearLayout, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("state", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("state") as State
        state.apply(linearLayout, textView)
    }
}

interface State: Serializable{
    fun apply(linearLayout: LinearLayout, textView: TextView)

    object Initial : State{
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
    }

    object Deleted : State{
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }
    }
}