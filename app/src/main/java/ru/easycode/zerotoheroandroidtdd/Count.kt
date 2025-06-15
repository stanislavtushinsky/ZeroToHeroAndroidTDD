package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState

    class Base(val step: Int, val max: Int, val min: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was -2")
            if (max < 0) throw IllegalStateException("max should be positive, but was -2")
            if (max < step) throw IllegalStateException("max should be more than step")
            if (min > max) throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            return if (number.toInt() == max) UiState.Max(number)
            else if (number.toInt() * 2 == max) UiState.Base(number)
            else UiState.Min(number)
        }

        override fun increment(number: String): UiState {
            return if (number.toInt() == step) UiState.Max(max.toString())
            else UiState.Base(step.toString())
        }

        override fun decrement(number: String): UiState {
            return if (number.toInt() == max) UiState.Base(step.toString())
            else UiState.Min(min.toString())
        }

    }
}