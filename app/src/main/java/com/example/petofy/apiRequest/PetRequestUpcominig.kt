package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetRequestUpcominig(
    @SerializedName("data")
    val `data`: PetRequestUpcominigData
)