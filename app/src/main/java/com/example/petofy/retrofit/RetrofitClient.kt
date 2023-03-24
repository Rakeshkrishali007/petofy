package com.example.petofy.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"
    val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }


     val apiInterface=RetrofitClient.retrofit.create(ApiInterfaces::class.java)

}

