package com.example.testkode.data.model

import com.google.gson.annotations.SerializedName

data class EmployeeList(
    @SerializedName("items")
    val items: List<Employee>,
)