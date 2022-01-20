package com.example.testkode.app.pages.list_of_employees

import com.example.testkode.domain.entities.EmployeeEntity

data class ListOfEmployeeViewState(
    val loading: Boolean,
    val entity: EmployeeEntity?,
    val isSuccess: Boolean = false,
    val errorMessage: Int?
)