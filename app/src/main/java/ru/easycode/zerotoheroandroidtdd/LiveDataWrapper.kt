package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {
    fun liveData(): LiveData<UiState>
    fun update(value: UiState)
    fun checkUpdateCalls(expected: List<UiState>)
}