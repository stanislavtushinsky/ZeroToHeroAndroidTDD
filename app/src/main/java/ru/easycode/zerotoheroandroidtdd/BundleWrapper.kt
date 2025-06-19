package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import ru.easycode.zerotoheroandroidtdd.BundleWrapper.Mutable

interface BundleWrapper {


    interface Save {
        fun save(uiState: UiState?)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable : Save, Restore {
        override fun save(uiState: UiState?)
        override fun restore(): UiState
    }

}

class BundleWrapperImpl(val bundle: Bundle) : Mutable {

    override fun save(uiState: UiState?) {
        bundle.putSerializable("state", uiState)
    }

    override fun restore(): UiState {
        return bundle.getSerializable("state") as UiState
    }

}
