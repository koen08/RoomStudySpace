package com.koen.roomstudyspace.di

import com.koen.roomstudyspace.navigation.GlobalFragmentManager
import com.koen.roomstudyspace.navigation.GlobalFragmentManagerImpl
import com.koen.roomstudyspace.navigation.HomeFragmentManager
import com.koen.roomstudyspace.navigation.HomeFragmentManagerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.createdAtStart
import org.koin.core.module.dsl.singleOf
import org.koin.core.qualifier.named
import org.koin.dsl.module

val navModule = module {

    /** Global navigation */
    singleOf(::GlobalFragmentManagerImpl) {
        this.bind<GlobalFragmentManager>()
    }

    /** Home navigation */
    singleOf(::HomeFragmentManagerImpl) {
        this.bind<HomeFragmentManager>()
    }

}