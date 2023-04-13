package com.example.petofy.apiResponse


import com.google.gson.annotations.SerializedName

data class AddPetResponseModelData(
    @SerializedName("address")
    val address: String,
    @SerializedName("ageOfPet")
    val ageOfPet: Double,
    @SerializedName("contactNumber")
    val contactNumber: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
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
    val petCategory: Any,
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
    val petProfileImageUrl: String,
    @SerializedName("petSex")
    val petSex: String,
    @SerializedName("petSexId")
    val petSexId: Double,
    @SerializedName("petSize")
    val petSize: Any,
    @SerializedName("petSizeId")
    val petSizeId: Double,
    @SerializedName("petUniqueId")
    val petUniqueId: String,
    @SerializedName("prefix")
    val prefix: Any,
    @SerializedName("userId")
    val userId: String
)