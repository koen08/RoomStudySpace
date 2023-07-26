package com.koen.roomstudyspace.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB: ViewBinding>(private val clazz: Class<VB>) : Fragment() {

    private var _binding : VB? = null
    val binding get() = _binding!!

    val tagName get() = this.clazz.name

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val method = clazz.getMethod("inflate", LayoutInflater::class.java)
        _binding = method.invoke(null, inflater) as VB
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}