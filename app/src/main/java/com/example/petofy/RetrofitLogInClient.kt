package com.example.petofy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitLogInClient {

    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    val logInterface by lazy {
        retrofit.create(LogIn_Inerface::class.java)
    }

}