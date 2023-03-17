package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class MyStaffResponseStaffDetail(
    @SerializedName("customerEmail")
    val customerEmail: Any,
    @SerializedName("email")
    val email: String,
    @SerializedName("encryptedId")
    val encryptedId: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("pagingHeader")
    val pagingHeader: Any,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("profileImageUrl")
    val profileImageUrl: Any,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userRole")
    val userRole: Any,
    @SerializedName("vetQualification")
    val vetQualification: String,
    @SerializedName("vetRegistrationNumber")
    val vetRegistrationNumber: String
)