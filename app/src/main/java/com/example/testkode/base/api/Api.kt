package com.example.testkode.base.api

import com.example.testkode.data.model.Employee
import com.example.testkode.data.model.EmployeeList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface Api {

    @Headers("Content-Type: application/json")
    @GET("/")
    suspend fun getAllEmployees(): Response<EmployeeList>

}