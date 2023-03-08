package com.almseit.cleanarchitecture.di

import android.content.Context
import com.almseit.cleanArchitecture.data.repository.UserRepositoryImpl
import com.almseit.cleanArchitecture.data.storage.SharedPrefsUserStorage
import com.almseit.cleanArchitecture.data.storage.UserStorage
import com.almseit.cleanArchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule{

    @Provides
    fun provideUserStorage(context:Context) : UserStorage{
        return SharedPrefsUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage) : UserRepository{
        return UserRepositoryImpl(userStorage = userStorage)
    }


}