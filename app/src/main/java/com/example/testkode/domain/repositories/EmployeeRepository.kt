package com.example.testkode.domain.repositories

import com.example.testkode.base.state.ResultState
import com.example.testkode.domain.entities.EmployeeEntity
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun getAllEmployees() : Flow<ResultState<EmployeeEntity>>
}