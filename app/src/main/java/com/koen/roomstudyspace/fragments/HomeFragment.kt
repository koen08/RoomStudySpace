package com.koen.roomstudyspace.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.koen.roomstudyspace.R
import com.koen.roomstudyspace.databinding.FragmentHomeBinding
import com.koen.roomstudyspace.fragments.list.ListFragment
import com.koen.roomstudyspace.fragments.main.MainFragment
import com.koen.roomstudyspace.invoke
import com.koen.roomstudyspace.navigation.HomeFragmentManager
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::class.java) {

    private val homeFragmentManager: HomeFragmentManager by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding {
            homeFragmentManager.setNavigator(
                fragmentManager = childFragmentManager,
                containerViewId = containerFragmentView.id
            )
            homeFragmentManager.add(MainFragment::class.java)
            bottomNavigationView.setOnItemSelectedListener { menuItem ->
                return@setOnItemSelectedListener when (menuItem.itemId) {
                    R.id.main -> {
                        homeFragmentManager.replace(
                            MainFragment::class.java
                        )
                        true
                    }

                    R.id.list -> {
                        homeFragmentManager.replace(
                            ListFragment::class.java
                        )
                        true
                    }

                    else -> true
                }
            }
        }
    }
}