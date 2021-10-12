package ru.kozirfm.news_api.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InNews(
    val id: Long,
    val date: String,
    val title: String,
    val link: String,
    val text: String,
    val images: List<String>?,
) : Parcelable