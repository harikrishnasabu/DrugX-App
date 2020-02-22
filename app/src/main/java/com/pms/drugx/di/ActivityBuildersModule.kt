package com.pms.drugx.di

import com.pms.drugx.di.auth.AuthModule
import com.pms.drugx.di.auth.AuthScope
import com.pms.drugx.di.auth.LoginViewModelModule
import com.pms.drugx.ui.login.LoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @AuthScope
    @ContributesAndroidInjector(
        modules = [AuthModule::class,LoginViewModelModule::class]
    )
    abstract fun contributeLoginActivity(): LoginActivity

}