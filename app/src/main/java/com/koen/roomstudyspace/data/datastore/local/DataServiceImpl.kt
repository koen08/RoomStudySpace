package com.koen.roomstudyspace.data.datastore.local

import com.koen.roomstudyspace.data.datastore.local.user.UserDao
import com.koen.roomstudyspace.data.datastore.local.user.UserEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class DataServiceImpl(
    private val userDao: UserDao
) : DataService {
    override suspend fun saveUser(firstName: String, lastName: String, age: Int, picture: String) {
        UserEntity(
            firstName = firstName,
            lastName = lastName,
            age = age,
            picture = picture
        ).also { userEntity ->
            userDao.insert(userEntity)
        }
    }
}