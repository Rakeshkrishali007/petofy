package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class login_request_fields(
    @SerializedName("Email")
    val email: String,
    @SerializedName("Password")
    val password: String
)