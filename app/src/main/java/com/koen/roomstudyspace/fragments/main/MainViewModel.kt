package com.koen.roomstudyspace.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.koen.roomstudyspace.data.datastore.local.DataService
import com.koen.roomstudyspace.data.datastore.remote.UserRemoteDataStore
import com.koen.roomstudyspace.data.datastore.remote.models.DobDto
import com.koen.roomstudyspace.data.datastore.remote.models.NameDto
import com.koen.roomstudyspace.data.datastore.remote.models.UserDto
import com.koen.roomstudyspace.fragments.list.ListFragment
import com.koen.roomstudyspace.navigation.GlobalFragmentManager
import com.koen.roomstudyspace.navigation.HomeFragmentManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRemoteDataStore: UserRemoteDataStore,
    private val globalFragmentManager: GlobalFragmentManager,
    private val homeFragmentManager: HomeFragmentManager,
    private val dataService: DataService
) : ViewModel() {

    val getUserStateFlow: MutableStateFlow<UserDto?> = MutableStateFlow(
        null
    )

    fun getUser() {
        viewModelScope.launch {
            userRemoteDataStore.getUser().also {
                getUserStateFlow.emit(it)
            }
        }
    }

    fun saveUser() {
        viewModelScope.launch {
            getUserStateFlow.value?.let { userInfo ->
                dataService.saveUser(
                    firstName = userInfo.nameDto.toString(),
                    lastName = userInfo.nameDto?.lastName.toString(),
                    age = userInfo.dobDto?.age ?: 0,
                    picture = userInfo.pictureDto?.thumbnail.toString()
                )
            }
        }
    }
}