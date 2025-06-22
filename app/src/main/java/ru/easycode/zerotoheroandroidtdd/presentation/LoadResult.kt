package ru.easycode.zerotoheroandroidtdd.presentation

import ru.easycode.zerotoheroandroidtdd.data.cloud.SimpleResponse

interface LoadResult {

    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Error(val noConnection: Boolean) : LoadResult {

        val text = if (noConnection) {
            "No internet connection"
        } else {
            "Something went wrong"
        }

        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(text))
        }
    }

    data class Success(val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(data.text))
        }
    }
}