package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class MyStaffResponseData(
    @SerializedName("pagingHeader")
    val pagingHeader: MyStaffResponsePagingHeader,
    @SerializedName("staffDetail")
    val staffDetail: List<MyStaffResponseStaffDetail>
)