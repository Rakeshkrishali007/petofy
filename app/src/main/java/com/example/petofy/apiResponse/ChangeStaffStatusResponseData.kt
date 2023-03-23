package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class ChangeStaffStatusResponseData(
    @SerializedName("address")
    val address: Any,
    @SerializedName("areYouProvider")
    val areYouProvider: Boolean,
    @SerializedName("cityId")
    val cityId: Int,
    @SerializedName("cityName")
    val cityName: Any,
    @SerializedName("clinicName")
    val clinicName: Any,
    @SerializedName("confirmPassword")
    val confirmPassword: Any,
    @SerializedName("contact")
    val contact: Any,
    @SerializedName("customerEmail")
    val customerEmail: Any,
    @SerializedName("customerPassword")
    val customerPassword: Any,
    @SerializedName("dateOfBirth")
    val dateOfBirth: Any,
    @SerializedName("dateOfJoining")
    val dateOfJoining: Any,
    @SerializedName("dateOfMarriage")
    val dateOfMarriage: Any,
    @SerializedName("displayInPrescription")
    val displayInPrescription: Boolean,
    @SerializedName("email")
    val email: Any,
    @SerializedName("employeeCode")
    val employeeCode: Any,
    @SerializedName("enableTwoStepVerification")
    val enableTwoStepVerification: Boolean,
    @SerializedName("encryptedId")
    val encryptedId: Any,
    @SerializedName("firstName")
    val firstName: Any,
    @SerializedName("forgotPasswordEmail")
    val forgotPasswordEmail: Any,
    @SerializedName("fullName")
    val fullName: Any,
    @SerializedName("guestEmail")
    val guestEmail: Any,
    @SerializedName("hasMasterVaccinationSchedule")
    val hasMasterVaccinationSchedule: Boolean,
    @SerializedName("hasOphrSubscription")
    val hasOphrSubscription: Boolean,
    @SerializedName("identityProof")
    val identityProof: Any,
    @SerializedName("initials")
    val initials: Any,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isAdminRedirected")
    val isAdminRedirected: Boolean,
    @SerializedName("isAllowPrescriptionAccess")
    val isAllowPrescriptionAccess: Boolean,
    @SerializedName("isEmailChanged")
    val isEmailChanged: Boolean,
    @SerializedName("isEmailVerified")
    val isEmailVerified: Boolean,
    @SerializedName("isLogin")
    val isLogin: Boolean,
    @SerializedName("isMobileNumberVerified")
    val isMobileNumberVerified: Boolean,
    @SerializedName("isPhone")
    val isPhone: Boolean,
    @SerializedName("isPrivacyPolicyCheck")
    val isPrivacyPolicyCheck: Boolean,
    @SerializedName("isProfileCreated")
    val isProfileCreated: Boolean,
    @SerializedName("isRegisteredPetParent")
    val isRegisteredPetParent: Boolean,
    @SerializedName("lastName")
    val lastName: Any,
    @SerializedName("latLong")
    val latLong: Any,
    @SerializedName("locationId")
    val locationId: Int,
    @SerializedName("locationList")
    val locationList: Any,
    @SerializedName("mobileNumber")
    val mobileNumber: Any,
    @SerializedName("notificationStatus")
    val notificationStatus: Boolean,
    @SerializedName("numberOfAppointments")
    val numberOfAppointments: Int,
    @SerializedName("numberOfPets")
    val numberOfPets: Int,
    @SerializedName("numberOfStaff")
    val numberOfStaff: Int,
    @SerializedName("onlineAppointmentStatus")
    val onlineAppointmentStatus: Boolean,
    @SerializedName("otp")
    val otp: Any,
    @SerializedName("password")
    val password: Any,
    @SerializedName("petId")
    val petId: Int,
    @SerializedName("petParentConfirmPassword")
    val petParentConfirmPassword: Any,
    @SerializedName("petParentPassword")
    val petParentPassword: Any,
    @SerializedName("phoneNumber")
    val phoneNumber: Any,
    @SerializedName("productId")
    val productId: Any,
    @SerializedName("profileImageUrl")
    val profileImageUrl: Any,
    @SerializedName("providerConfirmPassword")
    val providerConfirmPassword: Any,
    @SerializedName("providerEmail")
    val providerEmail: Any,
    @SerializedName("providerFirstName")
    val providerFirstName: Any,
    @SerializedName("providerLastName")
    val providerLastName: Any,
    @SerializedName("providerPassword")
    val providerPassword: Any,
    @SerializedName("providerPhoneNumber")
    val providerPhoneNumber: Any,
    @SerializedName("qualification")
    val qualification: Any,
    @SerializedName("rate")
    val rate: Any,
    @SerializedName("rememberMe")
    val rememberMe: Boolean,
    @SerializedName("roleId")
    val roleId: Any,
    @SerializedName("stateProvinceId")
    val stateProvinceId: Any,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("userPermissionMasterList")
    val userPermissionMasterList: List<Any>,
    @SerializedName("userRole")
    val userRole: Any,
    @SerializedName("userSalt")
    val userSalt: Any,
    @SerializedName("vetQualification")
    val vetQualification: Any,
    @SerializedName("vetRegistrationNumber")
    val vetRegistrationNumber: Any,
    @SerializedName("zipCode")
    val zipCode: Any
)