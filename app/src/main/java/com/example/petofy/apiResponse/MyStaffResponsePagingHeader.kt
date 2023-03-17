package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class MyStaffResponsePagingHeader(
    @SerializedName("hasNextPage")
    val hasNextPage: Boolean,
    @SerializedName("hasPreviousPage")
    val hasPreviousPage: Boolean,
    @SerializedName("nextPage")
    val nextPage: Int,
    @SerializedName("pageNumber")
    val pageNumber: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("previousPage")
    val previousPage: Int,
    @SerializedName("totalItems")
    val totalItems: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)