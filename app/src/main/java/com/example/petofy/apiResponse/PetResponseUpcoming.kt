package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetResponseUpcoming(
    @SerializedName("data")
    val `data`: List<PetResponseUpcomingData>
)