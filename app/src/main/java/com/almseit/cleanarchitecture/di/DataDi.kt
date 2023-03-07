package com.almseit.cleanarchitecture.di

import com.almseit.cleanArchitecture.data.repository.UserRepositoryImpl
import com.almseit.cleanArchitecture.data.storage.SharedPrefsUserStorage
import com.almseit.cleanArchitecture.data.storage.UserStorage
import com.almseit.cleanArchitecture.domain.repository.UserRepository
import org.koin.dsl.module



val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}