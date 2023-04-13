package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class AddPetResponseModel(
    @SerializedName("data")
    val `data`: AddPetResponseModelData,

)