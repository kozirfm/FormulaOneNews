package ru.kozirfm.news_api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OutNews(
    @SerialName("id")
    val id: Long,
    @SerialName("date")
    val date: String,
    @SerialName("title")
    val title: String,
    @SerialName("link")
    val link: String,
    @SerialName("text")
    val text: String,
    @SerialName("images")
    val images: List<String>? = null,
)