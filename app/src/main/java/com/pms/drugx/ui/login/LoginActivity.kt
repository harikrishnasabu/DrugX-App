package com.pms.drugx.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pms.drugx.R
import com.pms.drugx.data.datamodels.Login
import com.pms.drugx.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity :  DaggerAppCompatActivity() {
    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory

    lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProvider(this, providerFactory).get(LoginViewModel::class.java)
        viewModel.getLoginInfo().observe(this, Observer {login->

            println("LOGIN MODEL DATACHANGE: $login")
        })
    }

    fun navMainActivity(view: View) {
val login=Login(input_username.text.toString(),input_password.text.toString())
        viewModel.setLoginInfo(login)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}
