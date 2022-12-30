package com.almseit.cleanarchitecture.domain.repository

import com.almseit.cleanarchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanarchitecture.domain.model.UserName

interface UserRepository {

    fun saveName(param: SaveUserNameParam):Boolean

    fun getName():UserName
}