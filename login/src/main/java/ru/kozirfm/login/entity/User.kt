package ru.kozirfm.login.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val username: String,
    val password: String,
    val firebaseToken: String? = null
)