package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class ChangeStaffStatusResponse(
    @SerializedName("data")
    val `data`: ChangeStaffStatusResponseData,
    @SerializedName("response")
    val response: Reponse

)