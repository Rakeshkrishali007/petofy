package com.example.petofy.Header


import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("deviceId")
    val deviceId: Any,
    @SerializedName("platform")
    val platform: Any,
    @SerializedName("token")
    val token: String,
    @SerializedName("userId")
    val userId: String
)