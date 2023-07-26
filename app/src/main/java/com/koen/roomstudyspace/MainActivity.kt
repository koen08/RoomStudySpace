package com.koen.roomstudyspace

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.koen.roomstudyspace.databinding.ActivityMainBinding
import com.koen.roomstudyspace.fragments.HomeFragment
import com.koen.roomstudyspace.fragments.list.ListFragment
import com.koen.roomstudyspace.fragments.main.MainFragment
import com.koen.roomstudyspace.navigation.GlobalFragmentManager
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainActivityViewModel>()

    private var viewBinding: ActivityMainBinding? = null
    private val binding get() = viewBinding!!

    private val globalNavigationManager: GlobalFragmentManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding {
            globalNavigationManager.setNavigator(
                fragmentManager = supportFragmentManager,
                containerViewId = containerFragmentView.id
            )
            if (savedInstanceState == null) {
                globalNavigationManager.add(HomeFragment::class.java, bundleOf())
            }
        }
    }

    override fun onDestroy() {
        viewBinding = null
        super.onDestroy()
    }
}