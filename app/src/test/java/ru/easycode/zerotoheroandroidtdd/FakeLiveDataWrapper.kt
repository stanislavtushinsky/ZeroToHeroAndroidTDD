package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import org.junit.Assert

interface FakeLiveDataWrapper : LiveDataWrapper {

    override fun checkUpdateCalls(expected: List<UiState>)

    class Base : FakeLiveDataWrapper {

        private val actualCallsList = mutableListOf<UiState>()

        override fun checkUpdateCalls(expected: List<UiState>) {
            Assert.assertEquals(expected, actualCallsList)
        }

        override fun update(value: UiState) {
            actualCallsList.add(value)
        }

        override fun liveData(): LiveData<UiState> {
            throw IllegalStateException("not used in test")
        }
    }
}