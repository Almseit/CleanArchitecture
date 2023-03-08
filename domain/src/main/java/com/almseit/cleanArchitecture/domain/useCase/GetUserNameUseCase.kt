package com.almseit.cleanArchitecture.domain.useCase

import com.almseit.cleanArchitecture.domain.model.UserName
import com.almseit.cleanArchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName{
        return userRepository.getName()
    }


}