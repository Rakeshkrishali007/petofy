package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetPendingRequest(
    @SerializedName("data")
    val `data`: PetPendingRequestData
)