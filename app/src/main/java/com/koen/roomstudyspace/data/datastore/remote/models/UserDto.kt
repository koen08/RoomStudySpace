package com.koen.roomstudyspace.data.datastore.remote.models

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("name")
    val nameDto: NameDto? = null,
    @SerializedName("gender")
    val gender: String? = null,
    @SerializedName("dob")
    val dobDto: DobDto? = null,
    @SerializedName("picture")
    val pictureDto: PictureDto? = null
)