//package com.example.testkode.app.di
//
//import android.content.Context
//import com.example.testkode.app.di.modules.AppModule
//import com.example.testkode.app.di.modules.NetworkModule
//import com.example.testkode.app.pages.list_of_employees.ListOfEmployeesActivity
//import dagger.BindsInstance
//import dagger.Component
//import javax.inject.Singleton
//
//@Singleton
//@Component(modules = [AppModule::class, NetworkModule::class])
//interface AppComponent {
//    @Component.Builder
//    interface Builder {
//        fun build(): AppComponent
//
//        @BindsInstance
//        fun context(context: Context): Builder
//    }
//
//    fun inject(listOfEmployeesActivity: ListOfEmployeesActivity)
//
//}