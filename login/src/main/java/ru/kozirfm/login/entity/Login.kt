package ru.kozirfm.login.entity

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ru.kozirfm.utils.json.ISerializable

@Serializable
data class Login(
    val username: String,
    val password: String,
    val firebaseToken: String? = null
) : ISerializable {

    override fun toJsonString(): String {
        return Json.encodeToString(this)
    }

}