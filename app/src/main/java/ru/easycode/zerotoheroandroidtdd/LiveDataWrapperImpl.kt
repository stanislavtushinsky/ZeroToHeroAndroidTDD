package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LiveDataWrapperImpl : LiveDataWrapper {

    private val liveData: MutableLiveData<UiState> = MutableLiveData()

    override fun liveData(): LiveData<UiState> = liveData

    override fun update(value: UiState) {
        liveData.value = value
    }

    override fun checkUpdateCalls(expected: List<UiState>) = Unit
}