package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.easycode.zerotoheroandroidtdd.data.cloud.SimpleService
import ru.easycode.zerotoheroandroidtdd.data.repository.Repository
import ru.easycode.zerotoheroandroidtdd.presentation.LiveDataWrapperImpl
import ru.easycode.zerotoheroandroidtdd.presentation.MainViewModel

class MyApp : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: SimpleService = retrofit.create(SimpleService::class.java)

        viewModel = MainViewModel(
            LiveDataWrapperImpl(),
            Repository.Base(
                service,
                "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
            )
        )
    }
}