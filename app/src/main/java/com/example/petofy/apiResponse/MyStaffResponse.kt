package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class MyStaffResponse(
    @SerializedName("data")
    val `data`: MyStaffResponseData,


    )