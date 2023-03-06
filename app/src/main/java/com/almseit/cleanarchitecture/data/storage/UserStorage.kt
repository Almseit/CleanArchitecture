package com.almseit.cleanarchitecture.data.storage



interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}