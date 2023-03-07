package com.almseit.cleanArchitecture.domain.useCase

import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param:SaveUserNameParam) : Boolean{
       return userRepository.saveName(param)

    }
}