package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetSizeIdResponseModel(
    @SerializedName("data")
    val `data`: List<PetSizeIdResponseModelData>,

)