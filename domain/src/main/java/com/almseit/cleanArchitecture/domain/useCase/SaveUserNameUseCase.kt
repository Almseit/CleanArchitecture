package com.almseit.cleanArchitecture.domain.useCase

import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val repository: UserRepository) {
    fun execute(param:SaveUserNameParam) : Boolean{
       return repository.saveName(param)

    }
}