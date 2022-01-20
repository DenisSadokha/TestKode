package com.example.testkode.base.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import com.google.gson.GsonBuilder

import com.google.gson.Gson





object RetrofitBuilder {

    private const val URL = "https://stoplight.io/mocks/kode-education/trainee-test/25143926/users/"


    private fun getBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api: Api = getBuilder().create(Api::class.java)
}