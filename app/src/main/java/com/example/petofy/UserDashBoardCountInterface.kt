package com.example.petofy

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

const val dashboarecountendpoint="user/GetDashboardCounts"
interface UserDashBoardCountInterface {

    @GET(dashboarecountendpoint)
    fun GetDashBoardCount(@Header("Authorization",) token: String?):Call<UserDashBoardCountResponse>
}
