package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class userDashBoardCount_response_atributes(
    @SerializedName("numberOfAppointments")
    val numberOfAppointments: Int,
    @SerializedName("numberOfPets")
    val numberOfPets: Int,
    @SerializedName("numberOfStaffs")
    val numberOfStaffs: Int
)