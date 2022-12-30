package com.almseit.cleanarchitecture.domain.useCase

import com.almseit.cleanarchitecture.domain.model.UserName
import com.almseit.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val repository: UserRepository) {

    fun execute(): UserName{
        return repository.getName()
    }
}