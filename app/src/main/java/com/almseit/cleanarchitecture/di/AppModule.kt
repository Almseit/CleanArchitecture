package com.almseit.cleanarchitecture.di

import android.content.Context
import com.almseit.cleanArchitecture.domain.useCase.GetUserNameUseCase
import com.almseit.cleanArchitecture.domain.useCase.SaveUserNameUseCase
import com.almseit.cleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext() : Context{
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        saveUserNameUseCase: SaveUserNameUseCase,
        getUserNameUseCase: GetUserNameUseCase
    ): MainViewModelFactory {

        return MainViewModelFactory(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        )
    }
}