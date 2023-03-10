package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetPendingRequestData(
    @SerializedName("fromDate")
    val fromDate: String,
    @SerializedName("toDate")
    val toDate: String

)