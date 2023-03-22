package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class AddStaffResponse(
    @SerializedName("data")
    val `data`: AddStaffResponseData,
    @SerializedName("response")
    val response: Response
)