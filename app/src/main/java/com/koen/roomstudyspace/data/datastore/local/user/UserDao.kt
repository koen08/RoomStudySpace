package com.koen.roomstudyspace.data.datastore.local.user

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface UserDao {
    @Insert
    suspend fun insert(userEntity: UserEntity)
}