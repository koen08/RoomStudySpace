package com.koen.roomstudyspace.data.datastore.local.book

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = true) private val id: Int = 0,
    private val title: String,
    private val description: String
)