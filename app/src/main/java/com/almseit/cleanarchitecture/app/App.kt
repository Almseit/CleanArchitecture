package com.almseit.cleanarchitecture.app

import android.app.Application
import com.almseit.cleanarchitecture.di.AppComponent
import com.almseit.cleanarchitecture.di.AppModule
import com.almseit.cleanarchitecture.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}