package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetListResponse(
    @SerializedName("data")
    val `data`: petlist_response_feilds,

    )