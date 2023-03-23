package com.example.petofy.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitClient {

    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"
    val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()

    }


    val logInterface = RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val dashBoardCountInstance= RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val petlistintanse= RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val petpendingintance=RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val petupcomingintance=RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val staffintance=RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val addstaffintance=RetrofitClient.retrofit.create(ApiInterfaces::class.java)
    val changestatusintance=RetrofitClient.retrofit.create(ApiInterfaces::class.java)
}

