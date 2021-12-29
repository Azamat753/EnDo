package com.example.core

import retrofit2.Response

abstract class ResultWrapper {
    inline fun <T> getResult(call: () -> Response<T>): com.example.core.Response<T> {
        return try {
            call().asResponse
        } catch (e: Exception) {
            com.example.core.Response.Error(e)
        }
    }
}