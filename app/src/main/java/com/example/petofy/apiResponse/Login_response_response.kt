package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class login_response_response(
    @SerializedName("redirectUrl")
    val redirectUrl: String,
    @SerializedName("responseCode")
    val responseCode: Int,
    @SerializedName("responseMessage")
    val responseMessage: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("value")
    val value: Any
)