package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class UserDashBoardCountResponse(
    @SerializedName("data")
    val `data`: userDashBoardCount_response_atributes,
    @SerializedName("response")
    val response: userDashBoardCount_feilds
)