package com.koen.roomstudyspace.data.datastore.remote

import android.util.Log
import com.koen.roomstudyspace.data.datastore.remote.models.UserDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.RuntimeException

class UserRemoteDataStoreImpl constructor(
    private val userApi: UserApi
) : UserRemoteDataStore {
    override suspend fun getUser(): UserDto {
        val result = userApi.getUser().body()?.results ?: emptyList()
        return result.first()
    }
}

interface UserRemoteDataStore {
    suspend fun getUser(): UserDto
}