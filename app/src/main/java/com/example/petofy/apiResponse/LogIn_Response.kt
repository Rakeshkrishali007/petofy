package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class LogIn_Response(
    @SerializedName("data")
    val `data`: login_response_atributes,

    @SerializedName("response")
    val response: login_response_response
)