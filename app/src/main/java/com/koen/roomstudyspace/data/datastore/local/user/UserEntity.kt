package com.koen.roomstudyspace.data.datastore.local.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val uId: Int = 0,
    @ColumnInfo(name = "first_name", defaultValue = "") val firstName: String,
    @ColumnInfo(name = "last_name", defaultValue = "") val lastName: String,
    @ColumnInfo(name = "age", defaultValue = "0") val age: Int,
    @ColumnInfo(name = "picture", defaultValue = "") val picture: String,
)