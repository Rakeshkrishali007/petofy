package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetBreedRequestModelData(
    @SerializedName("getAll")
    val getAll: Boolean,
    @SerializedName("petCategoryId")
    val petCategoryId: Int
)