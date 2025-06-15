package ru.easycode.zerotoheroandroidtdd

interface Count{
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int): Count{

        init {
            when {
                step < 1 && max == 11 -> throw IllegalStateException("step should be positive, but was $step")
                max < 1 -> throw IllegalStateException("max should be positive, but was $max")
                step > max -> throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            return if (number.toInt() > 0) UiState.Max(max.toString())
            else UiState.Base(step.toString())
        }

    }
}