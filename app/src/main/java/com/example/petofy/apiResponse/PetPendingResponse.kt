package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetPendingResponse(
    @SerializedName("data")
    val info: List<PetPendingResponseData>,

)