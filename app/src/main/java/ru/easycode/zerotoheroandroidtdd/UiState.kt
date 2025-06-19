package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(textView: TextView, progressBar: ProgressBar, button: Button)

    object ShowProgress : UiState {
        override fun apply(
            textView: TextView,
            progressBar: ProgressBar,
            button: Button
        ) {
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            textView.visibility = View.GONE
        }
    }

    object ShowData : UiState {
        override fun apply(
            textView: TextView,
            progressBar: ProgressBar,
            button: Button
        ) {
            progressBar.visibility = View.GONE
            textView.visibility = View.VISIBLE
            button.isEnabled = true
        }
    }
}