package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {
    fun checkUpdateCalls(expected: List<UiState>)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>
}

class LiveDataWrapperImpl : LiveDataWrapper {

    private val actualCallsList = mutableListOf<UiState>()
    private val liveData: MutableLiveData<UiState> = MutableLiveData()

    override fun checkUpdateCalls(expected: List<UiState>) {
        actualCallsList.isEmpty()
    }

    override fun update(value: UiState) {
        liveData.value = value
    }

    override fun liveData(): LiveData<UiState> = liveData

}
