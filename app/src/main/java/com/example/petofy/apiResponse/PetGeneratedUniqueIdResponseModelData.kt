package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetGeneratedUniqueIdResponseModelData(
    @SerializedName("petUniqueId")
    val petUniqueId: String
)