package com.example.githubrepos

import android.app.Application
import com.example.githubrepos.di.*
import org.koin.core.context.startKoin

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        startKoin {
            modules(
                getNetworkModule(),
                getApiModule(),
                getRepositoryModule(),
                getUseCases(),
                getViewModels()
            )
        }
    }
}