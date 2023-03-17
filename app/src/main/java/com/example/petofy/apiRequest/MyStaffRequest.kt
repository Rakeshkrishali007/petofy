package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class MyStaffRequest(
    @SerializedName("data")
    val `data`: MyStaffRequestData
)