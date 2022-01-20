package com.example.testkode.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Employee(
    @SerializedName("id")
    val id: String,
    @SerializedName("avatarUrl")
    val avatarUrl: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("userTag")
    val userTag: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("birthday")
    var birthday: String,
    @SerializedName("phone")
    val phone: String
)