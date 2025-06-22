package ru.easycode.zerotoheroandroidtdd.presentation

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore {
        override fun save(uiState: UiState)
        override fun restore(): UiState
    }
}

class BundleWrapperImpl(private val bundle: Bundle) : BundleWrapper.Mutable {
    override fun save(uiState: UiState) {
        bundle.putSerializable("state", uiState)
    }

    override fun restore(): UiState {
        return bundle.getSerializable("state") as UiState
    }

}