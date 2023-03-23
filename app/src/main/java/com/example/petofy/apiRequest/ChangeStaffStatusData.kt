package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class ChangeStaffStatusData(
    @SerializedName("encryptedId")
    val encryptedId: String,
    @SerializedName("status")
    val status: Boolean
)