package com.almseit.cleanarchitecture.app

import android.app.Application
import com.almseit.cleanarchitecture.di.appModule
import com.almseit.cleanarchitecture.di.dataModule
import com.almseit.cleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}