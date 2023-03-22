package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class AddStaffRequest(
    @SerializedName("data")
    val `data`: AddStaffData
)