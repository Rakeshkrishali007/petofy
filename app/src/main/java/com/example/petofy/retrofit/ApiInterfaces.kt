package com.example.petofy.retrofit

import com.example.petofy.*
import com.example.petofy.apiRequest.Login_Request
import com.example.petofy.apiRequest.PetListRequest
import com.example.petofy.getpetlist.PetListResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterfaces {
    @POST("report/GetPetList")
    fun getPetList(@Header("Authorization",) token: String?, @Body petListRequest: PetListRequest): Call<PetListResponse>


    @POST("User/Login")
    fun login(@Body loginRequest: Login_Request):Call<LogIn_Response>



    @GET("user/GetDashboardCounts")
    fun GetDashBoardCount(@Header("Authorization",) token: String?):Call<UserDashBoardCountResponse>
}