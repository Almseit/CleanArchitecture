package com.almseit.cleanarchitecture.di

import com.almseit.cleanArchitecture.domain.useCase.GetUserNameUseCase
import com.almseit.cleanArchitecture.domain.useCase.SaveUserNameUseCase
import org.koin.dsl.module


val domainModule = module {

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }
}