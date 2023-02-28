package com.example.petofy


import com.google.gson.annotations.SerializedName

data class UserDashBoardCountResponse(
    @SerializedName("data")
    val `data`: DataXX,
    @SerializedName("response")
    val response: ResponseX
)