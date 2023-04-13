package com.example.petofy.apiResponse

import com.google.gson.annotations.SerializedName

data class Reponse(
    @SerializedName("responseCode")
    val responseCode:Int,
    @SerializedName("responseMessage")
    val responseMessage:String,
    @SerializedName("token")
    val token:String,
    @SerializedName("value")
    val value:String,
    @SerializedName("redirectUrl")
    val redirectUrl:String,


)
