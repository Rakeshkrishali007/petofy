package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetGeneratedUniqueIdResponseModel(
    @SerializedName("data")
    val `data`: PetGeneratedUniqueIdResponseModelData,

)