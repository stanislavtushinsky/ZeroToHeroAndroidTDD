package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun save(textView: TextView, button: Button)

    data class Base(var text: String) : UiState {
        override fun save(textView: TextView, button: Button) {
            textView.text = text
        }
    }

    data class Max(val text: String) : UiState {
        override fun save(textView: TextView, button: Button) {
            textView.text = text
            button.isEnabled = false
        }
    }

}