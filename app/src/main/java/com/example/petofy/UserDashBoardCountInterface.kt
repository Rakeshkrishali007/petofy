package com.example.petofy

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
const val dashboarecountendpoint="user/GetDashboardCounts"
interface UserDashBoardCountInterface {

    @GET(dashboarecountendpoint)
    fun GetDashBoardCount():Call<UserDashBoardCountResponse>
}
