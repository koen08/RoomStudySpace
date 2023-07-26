package com.koen.roomstudyspace.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class HomeFragmentManagerImpl : HomeFragmentManager {

    private var _fragmentManager: FragmentManager? = null
    private var _containerViewId: Int? = null

    override fun setNavigator(fragmentManager: FragmentManager, containerViewId: Int) {
        _fragmentManager = fragmentManager
        _containerViewId = containerViewId
    }

    override fun add(fragmentClass: Class<out Fragment>, args: Bundle?) {
        _containerViewId?.let { containerViewId ->
            _fragmentManager?.beginTransaction()?.add(
                containerViewId, fragmentClass, args
            )?.commit()
        }
    }

    override fun replace(fragmentClass: Class<out Fragment>, args: Bundle?) {
        _containerViewId?.let { containerViewId ->
            _fragmentManager?.beginTransaction()?.replace(
                containerViewId, fragmentClass, args
            )?.commit()
        }
    }
}