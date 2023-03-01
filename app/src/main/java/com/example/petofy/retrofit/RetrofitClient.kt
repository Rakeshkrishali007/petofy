package com.example.petofy.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {


    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"
    val retrofit2 by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }
}