package ru.easycode.zerotoheroandroidtdd

abstract class Count {

    fun increment(number: Int){}

}

data class Base(val step : Int): Count()