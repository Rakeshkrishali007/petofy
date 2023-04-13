package com.example.petofy.retrofit

import com.example.petofy.*
import com.example.petofy.apiRequest.*
import com.example.petofy.apiResponse.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterfaces {
    @POST("report/GetPetList")
    fun getPetList(
        @Header("Authorization") token: String?,
        @Body petListRequest: PetListRequest
    ): Call<PetListResponse>


    @POST("User/Login")
    fun login(@Body loginRequest: Login_Request): Call<LogIn_Response>


    @GET("user/GetDashboardCounts")
    fun GetDashBoardCount(@Header("Authorization") token: String?): Call<UserDashBoardCountResponse>

    @POST("appointment/GetPendingAppointments")
    fun getPendinRequest(
        @Header("Authorization") token: String?,
        @Body petPendingRequest: PetPendingRequest
    ): Call<PetPendingResponse>

    @POST("appointment/GetAppointmentByDate")
    fun getUpcomingRequest(
        @Header("Authorization") token: String?,
        @Body petRequestUpcominig: PetRequestUpcominig
    ): Call<PetResponseUpcoming>

    @POST("staff/GetStaffList")
    fun getStaffList(
        @Header("Authorization") token: String?,
        @Body mystaffdata: MyStaffRequest
    ): Call<MyStaffResponse>

    @POST("staff/AddStaff")
    fun addStaff(
        @Header("Authorization") token: String?,
        @Body addStaffRequest: AddStaffRequest
    ): Call<AddStaffResponse>

    @POST("staff/ChangeStatus")
    fun changeStaffStatus(
        @Header("Authorization") token: String?,
        @Body changedStaffStatusRequest: ChangedStaffStatusRequest
    ): Call<ChangeStaffStatusResponse>

    @GET("pet/GeneratePetUniqueId")
    fun getPetGeneratedUniqueId(@Header("Authorization") token: String?): Call<PetGeneratedUniqueIdResponseModel>

    @GET("common/GetPetTypes")
    fun getPetCategoty(@Header("Authorization") token: String?): Call<PetCategotyResponseModel>

    @POST("pet/AddPet")
    fun addPet(
        @Header("Authorization") token: String?,
        @Body addPetReqestModel: AddPetReqestModel
    ): Callback<AddPetResponseModel>

    @POST("pet/GetPetBreed")
    fun getPetBreed( @Header("Authorization") token: String?,@Body petBreedRequestModel: PetBreedRequestModel):Call<PetBreedResponseModel>

    @POST("pet/GetPetColor")
    fun getPeColor( @Header("Authorization") token: String?,@Body petColorRequestModel: PetColorRequestModel):Call<PetColorResponseModel>

    @POST("pet/GetPetSize")
    fun getPetSize(@Header("Authorization") token: String?, @Body petColorRequestModel: PetColorRequestModel) :Call<PetSizeIdResponseModel>



}

