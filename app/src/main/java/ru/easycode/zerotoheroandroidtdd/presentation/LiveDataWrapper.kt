package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    interface Update {
        fun update(value: UiState)
    }

    interface Mutable : Update {
        fun save(bundleWrapper: BundleWrapper.Save)
        override fun update(value: UiState)
        fun liveData(): LiveData<UiState>
    }
}

class LiveDataWrapperImpl : LiveDataWrapper.Mutable {

    private val liveData: MutableLiveData<UiState> = MutableLiveData<UiState>()

    override fun save(bundleWrapper: BundleWrapper.Save) {
        liveData.value.let { bundleWrapper.save(it!!) }
    }

    override fun update(value: UiState) {
        liveData.value = value
    }

    override fun liveData(): LiveData<UiState> = liveData

}