package ru.kozirfm.network_api.utils

sealed class ResponseState
class ResponseSuccess<T>(val data: T) : ResponseState()
class ResponseError(val code: Int, val message: String) : ResponseState()