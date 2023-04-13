package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetColorRequestModel(
    @SerializedName("data")
    val `data`: PetColorRequestModelData
)