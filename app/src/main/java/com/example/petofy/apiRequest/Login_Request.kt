package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class Login_Request(
    @SerializedName("data")
    val `data`: login_request_fields
)