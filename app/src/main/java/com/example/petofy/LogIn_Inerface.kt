package com.example.petofy

import retrofit2.Call
import retrofit2.http.POST

const val endpoint="User/Login"
interface LogIn_Inerface {

    @POST(endpoint)
    fun login(loginRequest: Login_Request):Call<LogIn_Response>
}