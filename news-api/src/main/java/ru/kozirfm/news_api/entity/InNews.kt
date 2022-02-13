package ru.kozirfm.news_api.entity

import kotlinx.serialization.Serializable

@Serializable
data class InNews(
    val id: Long,
    val date: String,
    val title: String,
    val link: String,
    val text: String,
    val images: List<String>?,
)