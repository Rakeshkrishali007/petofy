package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class AddStaffData(
    @SerializedName("confirmPassword")
    val confirmPassword: String,
    @SerializedName("displayInPrescription")
    val displayInPrescription: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("initials")
    val initials: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("vetQualification")
    val vetQualification: String,
    @SerializedName("vetRegistrationNumber")
    val vetRegistrationNumber: String
)