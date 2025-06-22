package ru.easycode.zerotoheroandroidtdd.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.data.repository.Repository

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository,
) : ViewModel() {

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        CoroutineScope(SupervisorJob() + Dispatchers.Main).launch {
            val result = repository.load()
            result.show(liveDataWrapper)
        }

    }

    fun liveData() = liveDataWrapper.liveData()

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }
}