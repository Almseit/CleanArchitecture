package com.almseit.cleanarchitecture.data.repository

import com.almseit.cleanarchitecture.data.storage.User
import com.almseit.cleanarchitecture.data.storage.UserStorage
import com.almseit.cleanarchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanarchitecture.domain.model.UserName
import com.almseit.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(val userStorage: UserStorage) : UserRepository{


    override fun saveName(param: SaveUserNameParam): Boolean {
       val user = mapToStorage(param)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user:User): UserName{
      return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}