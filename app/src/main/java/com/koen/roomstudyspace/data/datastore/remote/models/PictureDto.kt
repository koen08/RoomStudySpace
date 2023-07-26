package com.koen.roomstudyspace.data.datastore.remote.models

import com.google.gson.annotations.SerializedName

data class PictureDto(
    @SerializedName("thumbnail")
    val thumbnail: String? = null
)