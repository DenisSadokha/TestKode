//package com.example.testkode.app.di.modules
//
//import com.example.testkode.base.api.Api
//import com.example.testkode.base.api.RetrofitBuilder
//import dagger.Module
//import dagger.Provides
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton
//
//@Module
//class NetworkModule {
//
//
//    @Singleton
//    @Provides
//    fun provideRetrofit(): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl("https://stoplight.io/mocks/kode-education/trainee-test/25143926/users/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//
//    @Singleton
//    @Provides
//    fun provideRequestApi(retrofit: Retrofit): Api {
//        return retrofit.create(Api::class.java)
//    }
//
//
//
//
//
//}