package com.example.testkode.app.pages.list_of_employees

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testkode.R
import com.example.testkode.base.api.RetrofitBuilder
import com.example.testkode.base.state.ErrorState
import com.example.testkode.base.state.LoadingState
import com.example.testkode.base.state.SuccessState
import com.example.testkode.data.datasource.ListOfEmployeesApiSource
import com.example.testkode.data.repositories.EmployeeRepositoryImpl
import com.example.testkode.domain.use_cases.GetEmployeeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListOfEmployeesViewModel(
) : ViewModel() {
    private val _viewState = MutableLiveData<ListOfEmployeeViewState>()
    val viewState: LiveData<ListOfEmployeeViewState> = _viewState

    // move to di
    private val api = RetrofitBuilder.api
    private val apiSource = ListOfEmployeesApiSource(api)
    private val repositoryImpl = EmployeeRepositoryImpl(apiSource)
    private val getEmployeeUseCase = GetEmployeeUseCase(repositoryImpl)
    //---


    init {
        _viewState.value = ListOfEmployeeViewState(
            loading = false,
            entity = null,
            isSuccess = false,
            errorMessage = null
        )
    }

    fun getEmployees() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                getEmployeeUseCase.getAllEmployees()

            }.collect {
                when (it.state) {
                    is LoadingState -> {
                        _viewState.value = _viewState.value?.copy(
                            loading = true,
                            entity = null,
                            isSuccess = false,
                            errorMessage = null
                        )

                    }
                    is SuccessState -> {
                        _viewState.value = _viewState.value?.copy(
                            loading = false,
                            entity = it.t,
                            isSuccess = true,
                            errorMessage = null
                        )
                    }


                    is ErrorState -> {
                        _viewState.value = _viewState.value?.copy(
                            loading = false,
                            entity = null,
                            isSuccess = false,
                            errorMessage = R.string.http_error
                        )
                    }
                }
            }
        }
    }

}