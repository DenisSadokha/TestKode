package com.example.testkode.base.state

import com.example.testkode.base.entity.Entity

data class ResultState<T : Entity>(
    val state: State,
    val t: T?
)

sealed class State
data class LoadingState(val loading: Boolean) : State()
data class ErrorState(val errorMessage: Int ) : State()
data class SuccessState(val code: Int) : State()

