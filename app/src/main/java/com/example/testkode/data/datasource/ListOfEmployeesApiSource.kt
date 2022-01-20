package com.example.testkode.data.datasource

import android.util.Log
import com.example.testkode.base.api.Api
import com.example.testkode.base.api.SocketConn
import com.example.testkode.data.model.Employee
import com.example.testkode.data.model.EmployeeList
import com.google.gson.Gson


class ListOfEmployeesApiSource(val api: Api) {
    suspend fun getAllEmployees(): List<Employee>? {

        val socketConn = SocketConn()
        var response: List<Employee>? = listOf<Employee>()

         // val newResponse = api.getAllEmployees()
        val responseNew = socketConn.getResponse()
        val gson = Gson()
        Log.d("TADTAD", responseNew)


        val responseMock = "{items: [" +
                "{\n" +
                "  \"id\": \"1\",\n" +
                "  \"avatarUrl\": \"string\",\n" +
                "  \"firstName\": \"Petya\",\n" +
                "  \"lastName\": \"Nomerq\",\n" +
                "  \"userTag\": \"sss\",\n" +
                "  \"department\": \"QA\",\n" +
                "  \"position\": \"second\",\n" +
                "  \"phone\": \"890000000\",\n" +
                "  \"birthday\": \"11-11-1111\"\n" +
                "}" +
                "," +
                "{\n" +
                "  \"id\": \"2\",\n" +
                "  \"avatarUrl\": \"string\",\n" +
                "  \"firstName\": \"Vasya\",\n" +
                "  \"lastName\": \"Petrov\",\n" +
                "  \"userTag\": \"qw\",\n" +
                "  \"department\": \"QA\",\n" +
                "  \"position\": \"first\",\n" +
                "  \"phone\": \"89000002200\",\n" +
                "  \"birthday\": \"12-12-1212\"\n" +
                "}]" +
                "}"


        val employeeList = gson.fromJson<EmployeeList>(responseMock, EmployeeList::class.java)


        Log.d("myResp", "" + employeeList)

        response = (employeeList as EmployeeList).items ?: listOf()
//            if (newResponse.code() != 200) {
//            null
//        } else {
//            (newResponse.body() as EmployeeList).items ?: listOf()
//        }

        return response
    }

}