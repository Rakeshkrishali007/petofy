package com.example.petofy

import com.example.petofy.getpetlist.PetListClient
import com.example.petofy.getpetlist.PetListInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitLogInClient {

    val baseUrl = "https://petofyoptimizedapi.azurewebsites.net/api/"


    var mHttmLogginInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttmLogginInterceptor)
        .build()

    val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).client(
            mOkHttpClient)
            .build()

    }



}



