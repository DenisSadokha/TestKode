//package com.example.testkode.app.di.modules
//
//import com.example.testkode.data.datasource.ListOfEmployeesApiSource
//import com.example.testkode.data.repositories.EmployeeRepositoryImpl
//import com.example.testkode.domain.repositories.EmployeeRepository
//import dagger.Module
//import dagger.Provides
//
//@Module
//class AppModule {
//
//
//    @Provides
//    fun provideEmployeeRepository(apiSource: ListOfEmployeesApiSource): EmployeeRepository {
//        return EmployeeRepositoryImpl(apiSource)
//    }
//
//}