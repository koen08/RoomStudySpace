package com.koen.roomstudyspace.data.datastore.remote.models

import com.google.gson.annotations.SerializedName

data class DobDto(
    @SerializedName("age")
    val age: Int? = null
)