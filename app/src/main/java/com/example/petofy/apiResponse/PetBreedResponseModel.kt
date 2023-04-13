package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetBreedResponseModel(
    @SerializedName("data")
    val `data`: List<DatPetBreedResponseModelData>,

)