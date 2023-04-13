package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetColorResponseModel(
    @SerializedName("data")
    val `data`: List<PetColorResponseModelData>,

    )