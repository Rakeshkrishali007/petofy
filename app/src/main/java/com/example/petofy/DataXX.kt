package com.example.petofy


import com.google.gson.annotations.SerializedName

data class DataXX(
    @SerializedName("numberOfAppointments")
    val numberOfAppointments: Int,
    @SerializedName("numberOfPets")
    val numberOfPets: Int,
    @SerializedName("numberOfStaffs")
    val numberOfStaffs: Int
)