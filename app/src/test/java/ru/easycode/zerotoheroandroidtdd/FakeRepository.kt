package ru.easycode.zerotoheroandroidtdd

import org.junit.Assert

interface FakeRepository : Repository {

    override fun checkLoadCalledTimes(times: Int)

    class Base : FakeRepository {

        private var actualCalledTimes: Int = 0

        override fun checkLoadCalledTimes(times: Int) {
            Assert.assertEquals(times, actualCalledTimes)
        }

        override suspend fun load() {
            actualCalledTimes++
        }
    }
}