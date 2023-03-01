package com.example.petofy.getpetlist


import com.google.gson.annotations.SerializedName

data class DataX(

    @SerializedName("petList")
    val petList: List<Pet>
)