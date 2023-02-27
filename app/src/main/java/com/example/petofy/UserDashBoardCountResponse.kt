package com.example.petofy


import com.google.gson.annotations.SerializedName

data class UserDashBoardCountResponse(
    @SerializedName("data")
    val `data`: DataXX,
    @SerializedName("header")
    val header: Header,
    @SerializedName("response")
    val response: ResponseX
)