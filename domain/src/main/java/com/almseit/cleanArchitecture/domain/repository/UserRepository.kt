package com.almseit.cleanArchitecture.domain.repository

import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.model.UserName

interface UserRepository {

    fun saveName(param: SaveUserNameParam):Boolean

    fun getName():UserName
}