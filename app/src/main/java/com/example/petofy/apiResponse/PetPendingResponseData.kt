package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class PetPendingResponseData(
    @SerializedName("appointmentDate")
    val appointmentDate: String,
    @SerializedName("appointmentPurposeId")
    val appointmentPurposeId: Int,
    @SerializedName("className")
    val className: String,
    @SerializedName("companyName")
    val companyName: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("encrptedId")
    val encrptedId: Any,
    @SerializedName("encryptedPrescriptionId")
    val encryptedPrescriptionId: String,
    @SerializedName("encryptionId")
    val encryptionId: String,
    @SerializedName("endDateString")
    val endDateString: String,
    @SerializedName("eventFirstImage")
    val eventFirstImage: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("isActive")
    val isActive: Boolean,
    @SerializedName("isApproved")
    val isApproved: Boolean,
    @SerializedName("isVideoCall")
    val isVideoCall: Boolean,
    @SerializedName("location")
    val location: Any,
    @SerializedName("meetingId")
    val meetingId: String,
    @SerializedName("meetingUrl")
    val meetingUrl: String,
    @SerializedName("ngoUserId")
    val ngoUserId: Any,
    @SerializedName("paymentStatus")
    val paymentStatus: Boolean,
    @SerializedName("petAge")
    val petAge: String,
    @SerializedName("petCategoryId")
    val petCategoryId: Int,
    @SerializedName("petDOB")
    val petDOB: String,
    @SerializedName("petId")
    val petId: Int,
    @SerializedName("petName")
    val petName: String,
    @SerializedName("petParentMeetingUrl")
    val petParentMeetingUrl: String,
    @SerializedName("petParentName")
    val petParentName: String,
    @SerializedName("petProfileUrl")
    val petProfileUrl: String,
    @SerializedName("petSex")
    val petSex: String,
    @SerializedName("petUniqueId")
    val petUniqueId: String,
    @SerializedName("someImportantKeyID")
    val someImportantKeyID: Int,
    @SerializedName("startDateString")
    val startDateString: String,
    @SerializedName("statusColor")
    val statusColor: String,
    @SerializedName("statusString")
    val statusString: String,
    @SerializedName("subject")
    val subject: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: String,
    @SerializedName("vetName")
    val vetName: String,
    @SerializedName("vetProfileImage")
    val vetProfileImage: String,
    @SerializedName("veterinarianUserId")
    val veterinarianUserId: String
)