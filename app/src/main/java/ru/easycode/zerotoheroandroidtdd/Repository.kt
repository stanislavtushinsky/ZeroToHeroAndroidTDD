package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

interface Repository {
    fun checkLoadCalledTimes(times: Int)
    suspend fun load()
}

class RepositoryImpl() : Repository {

    override fun checkLoadCalledTimes(times: Int) = Unit

    override suspend fun load() {
        delay(3500)
    }
}