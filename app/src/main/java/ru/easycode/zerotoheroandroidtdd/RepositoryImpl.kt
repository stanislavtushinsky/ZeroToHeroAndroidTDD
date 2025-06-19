package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

class RepositoryImpl : Repository {
    override suspend fun load() {
        delay(3500)
    }

    override fun checkLoadCalledTimes(times: Int) = Unit
}