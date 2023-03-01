package com.example.petofy.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient {


    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"
    val retrofit2 by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }

    val
}