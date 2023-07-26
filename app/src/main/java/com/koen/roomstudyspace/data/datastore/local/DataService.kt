package com.koen.roomstudyspace.data.datastore.local

interface DataService {
    suspend fun saveUser(firstName: String, lastName: String, age: Int, picture: String)
}