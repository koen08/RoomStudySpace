package com.koen.roomstudyspace

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.flowWithLifecycle
import androidx.viewbinding.ViewBinding
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

inline operator fun <T : ViewBinding> T.invoke(binding: T.() -> Unit) {
    binding.invoke(this)
}

inline fun <T> MutableStateFlow<T>.collectLifecycle(
    scope: LifecycleCoroutineScope,
    lifecycle: Lifecycle,
    crossinline stateFlow: (T) -> Unit
) {
    scope.launch {
        this@collectLifecycle.flowWithLifecycle(lifecycle = lifecycle).collect {
            stateFlow.invoke(it)
        }
    }
}