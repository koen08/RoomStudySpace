package com.koen.roomstudyspace.data.datastore.remote.models

import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("results")
    val results: List<UserDto>? = null
)