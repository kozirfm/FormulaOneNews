package ru.kozirfm.network_api.entity

data class ServerResponse<T>(val state: String, val code: Int, val message: String, val result: T)