package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class AddStaffResponseData(
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("userRole")
    val userRole: String
)