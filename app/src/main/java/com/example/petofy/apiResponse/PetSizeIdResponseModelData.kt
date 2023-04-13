package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetSizeIdResponseModelData(
    @SerializedName("id")
    val id: Double,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("petCategory")
    val petCategory: Any,
    @SerializedName("petCategoryId")
    val petCategoryId: Int,
    @SerializedName("petDetail")
    val petDetail: List<Any>,
    @SerializedName("petDonation")
    val petDonation: List<Any>,
    @SerializedName("size")
    val size: String
)