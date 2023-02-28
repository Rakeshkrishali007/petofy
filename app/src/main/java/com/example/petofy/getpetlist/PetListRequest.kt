package com.example.petofy.getpetlist


import com.google.gson.annotations.SerializedName

data class PetListRequest(
    @SerializedName("data")
    val `data`: Data
)