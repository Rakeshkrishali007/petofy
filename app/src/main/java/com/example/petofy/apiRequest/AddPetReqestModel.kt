package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class AddPetReqestModel(
    @SerializedName("data")
    val `data`: AddPetRequestModelData
)