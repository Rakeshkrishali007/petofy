package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class MyStaffRequestData(
    @SerializedName("PageNumber")
    val pageNumber: String,
    @SerializedName("PageSize")
    val pageSize: String,
    @SerializedName("Search_Data")
    val searchData: String
)