package com.almseit.cleanarchitecture.domain.useCase

import com.almseit.cleanarchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val repository: UserRepository) {
    fun execute(param:SaveUserNameParam) : Boolean{
       return repository.saveName(param)

    }
}