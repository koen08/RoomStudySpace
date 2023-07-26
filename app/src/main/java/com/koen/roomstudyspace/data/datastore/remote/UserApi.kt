package com.koen.roomstudyspace.data.datastore.remote

import com.koen.roomstudyspace.data.datastore.remote.models.ResultDto
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {
    @GET("api/")
    suspend fun getUser(): Response<ResultDto>
}