package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class PetListRequest(
    @SerializedName("data")
    val `data`: petlist_request_feilds
)