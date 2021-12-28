package com.example.network

import retrofit2.Response
import java.lang.Error

abstract class ResultWrapper {
    inline fun <T> getResult(call: () -> Response<T>): com.example.network.Response<T> {
        return try {
            call().asResponse
        } catch (e: Exception) {
            com.example.network.Response.Error(e)
        }
    }
}