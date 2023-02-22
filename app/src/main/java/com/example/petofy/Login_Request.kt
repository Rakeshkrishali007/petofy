package com.example.petofy


import com.google.gson.annotations.SerializedName

data class Login_Request(
    @SerializedName("data")
    val `data`: Data
)