package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(textView: TextView, decBttn: Button, incBttn: Button)

    data class Min(val text: String) : UiState {
        override fun apply(
            textView: TextView,
            decBttn: Button,
            incBttn: Button
        ) {
            decBttn.isEnabled = false
            textView.text = text
            incBttn.isEnabled = true
        }
    }

    data class Base(val text: String) : UiState {
        override fun apply(
            textView: TextView,
            decBttn: Button,
            incBttn: Button
        ) {
            decBttn.isEnabled = true
            textView.text = text
            incBttn.isEnabled = true
        }
    }

    data class Max(val text: String) : UiState {
        override fun apply(
            textView: TextView,
            decBttn: Button,
            incBttn: Button
        ) {
            decBttn.isEnabled = true
            textView.text = text
            incBttn.isEnabled = false

        }
    }
}