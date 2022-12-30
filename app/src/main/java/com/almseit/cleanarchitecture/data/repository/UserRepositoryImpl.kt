package com.almseit.cleanarchitecture.data.repository

import android.content.Context
import com.almseit.cleanarchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanarchitecture.domain.model.UserName
import com.almseit.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_NAME = "default last name"

class UserRepositoryImpl(context: Context) : UserRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME,Context.MODE_PRIVATE)

    override fun saveName(param: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME,param.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        return UserName(firstName = firstName, lastName = lastName)
    }
}