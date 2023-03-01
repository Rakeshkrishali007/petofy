package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class petlist_response_atributes(
    @SerializedName("address")
    val address: String,
    @SerializedName("ageOfPet")
    val ageOfPet: Double,
    @SerializedName("contactNumber")
    val contactNumber: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: Any,
    @SerializedName("encryptedId")
    val encryptedId: String,
    @SerializedName("id")
    val id: Double,
    @SerializedName("petAge")
    val petAge: String,
    @SerializedName("petAgeId")
    val petAgeId: Double,
    @SerializedName("petBreed")
    val petBreed: String,
    @SerializedName("petBreedId")
    val petBreedId: Double,
    @SerializedName("petCategory")
    val petCategory: String,
    @SerializedName("petCategoryId")
    val petCategoryId: Int,
    @SerializedName("petColor")
    val petColor: String,
    @SerializedName("petColorId")
    val petColorId: Double,
    @SerializedName("petName")
    val petName: String,
    @SerializedName("petParentName")
    val petParentName: String,
    @SerializedName("petProfileImageUrl")
    val petProfileImageUrl: Any,
    @SerializedName("petSex")
    val petSex: String,
    @SerializedName("petSexId")
    val petSexId: Double,
    @SerializedName("petSize")
    val petSize: String,
    @SerializedName("petSizeId")
    val petSizeId: Double,
    @SerializedName("petUniqueId")
    val petUniqueId: String,
    @SerializedName("prefix")
    val prefix: Any,
    @SerializedName("userId")
    val userId: String
)