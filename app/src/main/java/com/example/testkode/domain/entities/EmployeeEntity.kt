package com.example.testkode.domain.entities

import com.example.testkode.base.entity.Entity
import java.util.*
data class EmployeeEntity(
    val data: List<Employee>
) : Entity

data class Employee(
    val id: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
    val userTag: String,
    val department: String,
    val position: String,
    val birthday: Date,
    val phone: String
)