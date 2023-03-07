package com.almseit.cleanarchitecture.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.almseit.cleanArchitecture.data.repository.UserRepositoryImpl
import com.almseit.cleanArchitecture.data.storage.SharedPrefsUserStorage
import com.almseit.cleanArchitecture.domain.useCase.GetUserNameUseCase
import com.almseit.cleanArchitecture.domain.useCase.SaveUserNameUseCase


class MainViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val userRepository by lazy { UserRepositoryImpl(userStorage = SharedPrefsUserStorage(context = context))}

    private val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }
    private val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(
            saveUserNameUseCase = saveUserNameUseCase,
            getUserNameUseCase = getUserNameUseCase
        ) as T
    }
}