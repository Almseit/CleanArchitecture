package com.almseit.cleanArchitecture.data.repository

import com.almseit.cleanArchitecture.data.storage.User
import com.almseit.cleanArchitecture.data.storage.UserStorage
import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.model.UserName
import com.almseit.cleanArchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(param: SaveUserNameParam): Boolean {
       val user = mapToStorage(param)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User{
        return User(firstName = saveParam.name, lastName = saveParam.name)
    }

    private fun mapToDomain(user:User): UserName{
      return UserName(firstName = user.firstName, lastName = user.lastName)
    }


}