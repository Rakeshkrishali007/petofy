package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetBreedRequestModel(
    @SerializedName("data")
    val `data`: PetBreedRequestModelData
)