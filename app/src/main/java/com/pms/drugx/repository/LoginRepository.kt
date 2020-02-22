package com.pms.drugx.repository

import com.pms.drugx.data.dao.FakeUserDao
import com.pms.drugx.data.datamodels.Login
import javax.inject.Inject

class LoginRepository
@Inject constructor( val userDao: FakeUserDao) {

    // This may seem redundant.
    // Imagine a code which also updates and checks the backend.
    fun setLoginInfo(login: Login) {
        userDao.setLoginInfo(login)
    }

    fun getLoginInfo() = userDao.getLoginInfo()

    companion object {
        // Singleton instantiation you already know and love
        @Volatile private var instance: LoginRepository? = null

        fun getInstance(userDao: FakeUserDao) =
            instance ?: synchronized(this) {
                instance ?: LoginRepository(userDao).also { instance = it }
            }
    }
}