package com.example.petofy.getpetlist


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("PageNumber")
    val pageNumber: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("search_Data")
    val searchData: String
)