package com.example.petofy.getpetlist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PetListClient {
    val retrofit by lazy {
        val baseUrl:String="https://petofyoptimizedapi.azurewebsites.net/api/"

        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val petlistintanse= retrofit.create(PetListInterface::class.java)
}