package com.koen.roomstudyspace.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface NavigationHelper {

    fun setNavigator(fragmentManager: FragmentManager, containerViewId: Int)

    fun add(
        fragmentClass: Class<out Fragment>,
        args: Bundle? = null
    )

    fun replace(
        fragmentClass: Class<out Fragment>,
        args: Bundle? = null
    )
}