package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * Please also check out the ui test
 * @see ru.easycode.zerotoheroandroidtdd.Task015Test
 */
class MainViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun test() {
        val repository = FakeRepository.Base()
        val liveDataWrapper = FakeLiveDataWrapper.Base()
        val viewModel = MainViewModel(
            liveDataWrapper = liveDataWrapper,
            repository = repository
        )
        viewModel.load()
        liveDataWrapper.checkUpdateCalls(listOf(UiState.ShowProgress, UiState.ShowData))
        repository.checkLoadCalledTimes(1)
    }
}

