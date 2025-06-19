package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApp : Application() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        viewModel = MainViewModel(
            LiveDataWrapperImpl(),
            Repository.Base(
                retrofit.create(SimpleService::class.java),
                BASE_URL
            )
        )
    }

    fun provideViewModel() = viewModel

    companion object {
        val BASE_URL =
            "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    }
}

