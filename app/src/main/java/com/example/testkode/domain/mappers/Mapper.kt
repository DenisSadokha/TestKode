package com.example.testkode.domain.mappers

import android.annotation.SuppressLint
import com.example.testkode.data.model.Employee
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
fun List<Employee>.toEntity(): List<com.example.testkode.domain.entities.Employee> {
    var correct: MutableList<com.example.testkode.domain.entities.Employee> = mutableListOf()
    val date = SimpleDateFormat("dd-mm-yyyy")
    this.forEach {
        val correctDate = date.parse(it.birthday)
        correct.add(
            com.example.testkode.domain.entities.Employee(
                id = it.id,
                avatarUrl = it.avatarUrl,
                firstName = it.firstName,
                lastName = it.lastName,
                userTag = it.userTag,
                department = it.department,
                position = it.position,
                birthday = correctDate!!,
                phone = it.phone
            )
        )
    }

    return correct

}