package com.pms.drugx.di.auth
import com.pms.drugx.data.FakeDatabase
import com.pms.drugx.data.dao.FakeUserDao
import com.pms.drugx.repository.LoginRepository
import dagger.Module
import dagger.Provides

@Module
class AuthModule{

//    @AuthScope
//    @Provides
//    fun provideOpenApiAuthService(retrofitBuilder: Retrofit.Builder): OpenApiAuthService {
//        return retrofitBuilder
//            .build()
//            .create(OpenApiAuthService::class.java)
//    }
    @AuthScope
    @Provides
 fun provideLoginRepository(
        ): LoginRepository {
        return LoginRepository(
            FakeDatabase.getInstance().userDao
        )
    }

}