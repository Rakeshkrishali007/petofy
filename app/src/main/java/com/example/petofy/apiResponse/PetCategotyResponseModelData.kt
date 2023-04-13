package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetCategotyResponseModelData(
    @SerializedName("encryptedId")
    val encryptedId: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("petType1")
    val petType1: String
)