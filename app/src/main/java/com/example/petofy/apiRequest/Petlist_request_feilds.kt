package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class petlist_request_feilds(
    @SerializedName("PageNumber")
    val pageNumber: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("search_Data")
    val searchData: String
)