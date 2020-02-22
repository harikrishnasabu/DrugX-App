package com.pms.drugx.ui.login

import androidx.lifecycle.ViewModel
import com.pms.drugx.data.datamodels.Login
import com.pms.drugx.repository.LoginRepository
import javax.inject.Inject


class LoginViewModel
@Inject
   constructor
    ( val loginRepository: LoginRepository)
    : ViewModel() {

    fun getLoginInfo() = loginRepository.getLoginInfo()

    fun setLoginInfo(login: Login) = loginRepository.setLoginInfo(login)
}