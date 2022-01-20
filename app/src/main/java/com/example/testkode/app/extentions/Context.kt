//package com.example.testkode.app.extentions
//
//import android.content.Context
//import com.example.testkode.App
//import com.example.testkode.app.di.AppComponent
//
//val Context.appComponent: AppComponent
//get() = when(this) {
//    is App -> appComponent
//    else -> this.applicationContext.appComponent
//}