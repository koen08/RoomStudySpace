package com.koen.roomstudyspace.fragments.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.koen.roomstudyspace.collectLifecycle
import com.koen.roomstudyspace.databinding.FragmentMainBinding
import com.koen.roomstudyspace.fragments.BaseFragment
import com.koen.roomstudyspace.invoke
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::class.java) {

    private val viewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding {
            next.setOnClickListener {
                viewModel.getUser()
            }
            save.setOnClickListener {
                viewModel.saveUser()
            }
            viewModel.getUserStateFlow.collectLifecycle(lifecycleScope, lifecycle) { user ->
                user?.let { userNotNull ->
                    tvName.text =
                        userNotNull.nameDto?.fistName + " " + userNotNull.nameDto?.lastName
                    tvAge.text = userNotNull.dobDto?.age.toString()
                    Glide.with(requireContext()).load(userNotNull.pictureDto?.thumbnail)
                        .into(imgAvatar)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}