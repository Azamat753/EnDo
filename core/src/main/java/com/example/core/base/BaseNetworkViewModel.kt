package com.example.core.base

import androidx.lifecycle.ViewModel
import com.example.core.utils.Response
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


open class BaseNetworkViewModel : ViewModel(){

    private val _loadingState: MutableStateFlow<Boolean> =
        MutableStateFlow(false)
    val loadingState: StateFlow<Boolean> =
        _loadingState.asStateFlow()

    private val _errorState = MutableStateFlow<Response.Error?>(null)
    val errorState: StateFlow<Response.Error?> =
        _errorState.asStateFlow()


    protected inline fun <reified T> handleResponse(
        response: Response<T>,
        mutableStateFlow: MutableStateFlow<T>? = null,
        onSuccess: (T?) -> Unit = {}) {
        showLoading()
        if (response is Response.Success) {
            onSuccess(response.data)
            mutableStateFlow?.value = response.data ?: null as T
        } else {
            showError(response)
        }
    }

    protected fun showLoading() {
        _loadingState.value = false
    }

    protected fun showError(resource: Response<Any?>) {
        _errorState.value = resource as? Response.Error
    }
}