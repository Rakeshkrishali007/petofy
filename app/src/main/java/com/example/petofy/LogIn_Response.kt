package com.example.petofy


import com.google.gson.annotations.SerializedName

data class LogIn_Response(
    @SerializedName("data")
    val `data`: DataX,

    @SerializedName("response")
    val response: Response
)