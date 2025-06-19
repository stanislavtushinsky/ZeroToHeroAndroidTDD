package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class MyApplication : Application() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(LiveDataWrapperImpl(), RepositoryImpl())

    }

    fun provideViewModel(): MainViewModel {
        return viewModel
    }
}