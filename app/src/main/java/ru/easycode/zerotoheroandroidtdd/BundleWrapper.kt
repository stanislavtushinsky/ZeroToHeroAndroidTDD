package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore
}

class BundleWrapperImpl(val bundle: Bundle) : BundleWrapper.Mutable {

    override fun save(uiState: UiState) {
        bundle.putSerializable("state", uiState)
    }

    override fun restore(): UiState {
        return bundle.getSerializable("state") as UiState
    }

}