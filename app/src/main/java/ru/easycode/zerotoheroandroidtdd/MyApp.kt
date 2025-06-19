package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import android.util.Log

class MyApp : Application() {

    private lateinit var viewModel: MainViewModel

    init {
        Log.d("test", "app init")
    }

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapperImpl(), RepositoryImpl())
        Log.d("test", "app onCreate")
    }

    fun provideViewModel() = viewModel

}