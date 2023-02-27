package com.example.petofy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object UserDashBoardCountClient {


    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"
    val retrofit2 by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }
    val dashBoardCountInstance= retrofit2.create(UserDashBoardCountInterface::class.java)
}