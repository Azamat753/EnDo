package com.example.core.utils

import retrofit2.Response

abstract class ResultWrapper {
    inline fun <T> getResult(call: () -> Response<T>): com.example.core.utils.Response<T> {
        return try {
            call().asResponse
        } catch (e: Exception) {
            com.example.core.utils.Response.Error(e)
        }
    }
}