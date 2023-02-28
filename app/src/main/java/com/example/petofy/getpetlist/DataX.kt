package com.example.petofy.getpetlist


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("pagingHeader")
    val pagingHeader: PagingHeader,
    @SerializedName("petList")
    val petList: List<Pet>
)