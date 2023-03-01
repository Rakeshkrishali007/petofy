package com.example.petofy.getpetlist

import com.example.petofy.Login_Request
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

const val baseUrl="report/GetPetList"
interface PetListInterface {

    @POST(baseUrl)
    fun getPetList(@Header("Authorization",) token: String?, @Body petListRequest: PetListRequest):Call<PetListResponse>
}

