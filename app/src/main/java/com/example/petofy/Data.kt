package com.example.petofy


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("Email")
    val email: String,
    @SerializedName("Password")
    val password: String
)