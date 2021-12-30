package com.example.core.utils

import android.accounts.NetworkErrorException
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


sealed class Response<out R> {

    data class Success<out T>(val data: T?) : Response<T>()
    data class Error(val exception: Exception) : Response<Nothing>() {

        val isNetworkError = exception is NetworkErrorException
                || exception is SocketTimeoutException
                || exception is UnknownHostException
                || exception is ConnectException
                || exception is IOException

        val isApiException = exception is ApiException

        //val isNotAuthorized = exception is HttpException && exception.code() == UNAUTHORIZED
        val isNotFoundException = exception is ApiException && exception.response?.code() == 404

        val isHttpException = exception is HttpException
    }

    data class Loading(val isLoading: Boolean = true) : Response<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success [data=$data]"
            is Error -> "Error [exception=$exception]"
            is Loading -> "Loading"
        }
    }

}

class ApiException(val response: retrofit2.Response<*>? = null) : Exception(response?.message())

inline val <T> retrofit2.Response<T>.asResponse: Response<T>
    get() = try {
        if (this.isSuccessful) {
            Response.Success(this.body())
        } else {
            Response.Error(ApiException(this))
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Response.Error(e)
    }

