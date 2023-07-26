package com.koen.roomstudyspace.data.datastore.remote.models

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("first")
    val fistName: String? = null,
    @SerializedName("last")
    val lastName: String? = null,
)
