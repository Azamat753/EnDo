package com.example.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.core.utils.Response
import com.example.core.extensions.launchWhenStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach


abstract class BaseFragment<T : ViewBinding>(private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T) :
    Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
        setArgsValue()
        initObserver()
        initAdapter()
    }

    open fun setArgsValue() {

    }

    abstract fun initObserver()
    abstract fun initClickers()
    open fun initAdapter(){

        fun <T> observeResponse(
            stateFlow: StateFlow<Response<T>?>,
            onLoading: (Boolean) -> Unit = {},
            onError: (Response.Error) -> Unit = {},
            onSuccess: (T?) -> Unit = {}
        ) {
            stateFlow.onEach {
                if (it != null) {
                    onLoading.invoke(it is Response.Loading)
                    when (it) {
                        is Response.Error -> onError.invoke(it)
                        is Response.Success -> onSuccess.invoke(it.data)
                    }
                }
            }.launchWhenStarted(lifecycleScope)
        }
    }
}

