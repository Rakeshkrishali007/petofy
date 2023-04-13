package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetCategotyResponseModel(
    @SerializedName("data")
    val `data`: List<PetCategotyResponseModelData>,

)