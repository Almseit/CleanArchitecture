package com.almseit.cleanArchitecture.data.storage



interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}