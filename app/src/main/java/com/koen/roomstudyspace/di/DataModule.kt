package com.koen.roomstudyspace.di

import androidx.room.Room
import com.koen.roomstudyspace.MainActivityViewModel
import com.koen.roomstudyspace.data.datastore.local.AppDataBase
import com.koen.roomstudyspace.data.datastore.local.DataService
import com.koen.roomstudyspace.data.datastore.local.DataServiceImpl
import com.koen.roomstudyspace.data.datastore.local.MIGRATION_1_2
import com.koen.roomstudyspace.data.datastore.remote.UserApi
import com.koen.roomstudyspace.data.datastore.remote.UserRemoteDataStore
import com.koen.roomstudyspace.data.datastore.remote.UserRemoteDataStoreImpl
import com.koen.roomstudyspace.fragments.main.MainViewModel
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val ROOM_DATA_BASE_NAME = "room_data_base"

val dataModule = module {

    /** Data repository */
    singleOf(::DataServiceImpl) {
        this.bind<DataService>()
    }

    /** ViewModel */
    viewModelOf(::MainActivityViewModel)

    /** Init data base */
    single {
        Room.databaseBuilder(
            androidContext(), AppDataBase::class.java, ROOM_DATA_BASE_NAME
        ).addMigrations(MIGRATION_1_2).build()
    }

    /** UserDao */
    single {
        get<AppDataBase>().userDao()
    }

    singleOf(::UserRemoteDataStoreImpl) {
        bind<UserRemoteDataStore>()
    }

    viewModelOf(::MainViewModel)

}