package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetRequestUpcominigData(
    @SerializedName("fromDate")
    val fromDate: String
)