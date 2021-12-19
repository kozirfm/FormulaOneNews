package ru.kozirfm.network_api.entity

import kotlinx.serialization.Serializable

@Serializable
data class ServerResponse(val state: String, val code: Int, val message: String, val result: String)