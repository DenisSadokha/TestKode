package com.example.testkode.data.repositories

import com.example.testkode.base.state.ErrorState
import com.example.testkode.base.state.LoadingState
import com.example.testkode.base.state.ResultState
import com.example.testkode.base.state.SuccessState
import com.example.testkode.data.datasource.ListOfEmployeesApiSource
import com.example.testkode.domain.entities.EmployeeEntity
import com.example.testkode.domain.mappers.toEntity
import com.example.testkode.domain.repositories.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class EmployeeRepositoryImpl(
    val apiSource: ListOfEmployeesApiSource
) : EmployeeRepository {

    override suspend fun getAllEmployees(): Flow<ResultState<EmployeeEntity>> {
        return flow<ResultState<EmployeeEntity>> {
            emit(
                ResultState(
                    LoadingState(loading = true), null
                )
            )

            val response = apiSource.getAllEmployees()

            when (response) {
                null -> {
                    emit(
                        ResultState(
                            ErrorState(228), null
                        )
                    )
                }
                else -> {
                    emit(
                        ResultState(
                            SuccessState(200),
                            EmployeeEntity(response.toEntity())
                        )
                    )

                }
            }


        }
    }
}