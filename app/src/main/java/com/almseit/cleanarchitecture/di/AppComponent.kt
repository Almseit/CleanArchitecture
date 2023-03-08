package com.almseit.cleanarchitecture.di

import com.almseit.cleanarchitecture.presentation.MainActivity
import dagger.Component


@Component(modules = [AppModule::class,DomainModule::class,DataModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}