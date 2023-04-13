package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetColorResponseModelData(
    @SerializedName("color")
    val color: String,
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
    val petDonation: List<Any>
)