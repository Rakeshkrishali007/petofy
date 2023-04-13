package com.example.petofy.apiRequest


import com.google.gson.annotations.SerializedName

data class AddPetRequestModelData(
    @SerializedName("address")
    val address: String,
    @SerializedName("contactNumber")
    val contactNumber: String,
    @SerializedName("createDate")
    val createDate: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("fifthServiceImageUrl")
    val fifthServiceImageUrl: String,
    @SerializedName("firstServiceImageUrl")
    val firstServiceImageUrl: String,
    @SerializedName("fourthServiceImageUrl")
    val fourthServiceImageUrl: String,
    @SerializedName("microchipNumber")
    val microchipNumber: String,
    @SerializedName("petAgeId")
    val petAgeId: Double,
    @SerializedName("petBreedId")
    val petBreedId: Double,
    @SerializedName("petCategoryId")
    val petCategoryId: Int,
    @SerializedName("petColorId")
    val petColorId: Double,
    @SerializedName("petName")
    val petName: String,
    @SerializedName("petParentName")
    val petParentName: String,
    @SerializedName("petProfileImageUrl")
    val petProfileImageUrl: String,
    @SerializedName("petSexId")
    val petSexId: Double,
    @SerializedName("petSizeId")
    val petSizeId: Double,
    @SerializedName("petUniqueId")
    val petUniqueId: Int,
    @SerializedName("secondServiceImageUrl")
    val secondServiceImageUrl: String,
    @SerializedName("thirdServiceImageUrl")
    val thirdServiceImageUrl: String
)