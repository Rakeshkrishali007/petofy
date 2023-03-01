package com.example.petofy.apiResponse


import com.example.petofy.getpetlist.PagingHeader
import com.google.gson.annotations.SerializedName

data class petlist_response_feilds(
    @SerializedName("pagingHeader")
    val pagingHeader: PagingHeader,
    @SerializedName("petList")
    val petList: List<petlist_response_atributes>
)