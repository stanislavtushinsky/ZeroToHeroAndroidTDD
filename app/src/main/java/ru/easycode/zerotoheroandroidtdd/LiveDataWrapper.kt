package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {
    fun save(bundleWrapper: BundleWrapper.Save)
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>
}

class LiveDataWrapperImpl : LiveDataWrapper {

    private val liveData: MutableLiveData<UiState> = SingleLiveEvent()

    override fun save(bundleWrapper: BundleWrapper.Save) {
        bundleWrapper.save(liveData.value!!)
    }

    override fun update(value: UiState) {
        liveData.value = value
    }

    override fun liveData(): LiveData<UiState> = liveData

}
