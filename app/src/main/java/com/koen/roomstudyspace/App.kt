package com.koen.roomstudyspace

import android.app.Application
import com.koen.roomstudyspace.di.dataModule
import com.koen.roomstudyspace.di.navModule
import com.koen.roomstudyspace.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                retrofitModule,
                dataModule,
                navModule,
            )
        }
    }

}