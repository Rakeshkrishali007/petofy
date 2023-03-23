package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class ChangedStaffStatusRequest(
    @SerializedName("data")
    val `data`: ChangeStaffStatusData
)