package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class userDashBoardCount_feilds(
    @SerializedName("redirectUrl")
    val redirectUrl: String,
    @SerializedName("responseCode")
    val responseCode: Int,
    @SerializedName("responseMessage")
    val responseMessage: String,
    @SerializedName("token")
    val token: Any,
    @SerializedName("value")
    val value: Any
)