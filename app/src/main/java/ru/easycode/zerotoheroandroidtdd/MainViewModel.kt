package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    val liveDataWrapper: LiveDataWrapper,
    val repository: Repository
) : ViewModel() {

    fun getLiveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate).launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }
}