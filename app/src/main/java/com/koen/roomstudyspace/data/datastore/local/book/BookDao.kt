package com.koen.roomstudyspace.data.datastore.local.book

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface BookDao {
    @Insert
    fun insert(bookEntity: BookEntity)
}