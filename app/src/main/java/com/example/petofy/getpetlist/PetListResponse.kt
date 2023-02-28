package com.example.petofy.getpetlist


import com.google.gson.annotations.SerializedName

data class PetListResponse(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("header")
    val header: Header,
    @SerializedName("response")
    val response: Response
)