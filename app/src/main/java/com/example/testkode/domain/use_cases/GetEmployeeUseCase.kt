package com.example.testkode.domain.use_cases

import com.example.testkode.base.state.ResultState
import com.example.testkode.domain.entities.Employee
import com.example.testkode.domain.entities.EmployeeEntity
import com.example.testkode.domain.repositories.EmployeeRepository
import kotlinx.coroutines.flow.Flow

class GetEmployeeUseCase(val repository: EmployeeRepository) {

    suspend fun getAllEmployees(): Flow<ResultState<EmployeeEntity>> =
        repository.getAllEmployees()


    suspend fun sortEmployeesByDepartment(
        department: String,
        employees: List<Employee>
    ): Flow<ResultState<EmployeeEntity>> =
        repository.getAllEmployees()

    suspend fun getSortEmployees(): Flow<ResultState<EmployeeEntity>> =
        repository.getAllEmployees()


}