package com.example.petofy


import com.google.gson.annotations.SerializedName

data class DataX(
    @SerializedName("address")
    val address: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("enableTwoStepVerification")
    val enableTwoStepVerification: Boolean,
    @SerializedName("encryptedId")
    val encryptedId: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("fullName")
    val fullName: Any,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean,
    @SerializedName("isProfileCreated")
    val isProfileCreated: Boolean,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("onlineAppointmentStatus")
    val onlineAppointmentStatus: Boolean,
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @SerializedName("profileImageUrl")
    val profileImageUrl: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userPermissionMasterList")
    val userPermissionMasterList: List<Any>,
    @SerializedName("userRole")
    val userRole: String,
    @SerializedName("vetQualification")
    val vetQualification: String,
    @SerializedName("vetRegistrationNumber")
    val vetRegistrationNumber: String
)