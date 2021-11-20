package ru.kozirfm.news.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
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
) : Parcelable