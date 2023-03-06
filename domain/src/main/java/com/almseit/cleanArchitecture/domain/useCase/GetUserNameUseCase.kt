package com.almseit.cleanArchitecture.domain.useCase

import com.almseit.cleanArchitecture.domain.model.UserName
import com.almseit.cleanArchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute(): UserName{
        return repository.getName()
    }


}