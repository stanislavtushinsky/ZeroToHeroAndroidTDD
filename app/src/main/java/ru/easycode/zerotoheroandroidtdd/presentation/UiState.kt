package ru.easycode.zerotoheroandroidtdd.presentation

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)

    data class ShowData(val text: String) : UiState {
        override fun apply(
            textView: TextView,
            button: Button,
            progressBar: ProgressBar,
        ) {
            textView.text = text
            progressBar.visibility = View.GONE
            button.isEnabled = true
        }
    }

    object ShowProgress : UiState {
        override fun apply(
            textView: TextView,
            button: Button,
            progressBar: ProgressBar,
        ) {
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            textView.visibility = View.GONE
        }
    }
}