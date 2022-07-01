package ru.kozirfm.calendar_api.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class OutCalendar(
    @SerialName("id")
    val id: Long,
    @SerialName("date")
    val date: String,
    @SerialName("country")
    val country: String,
    @SerialName("countryFlag")
    val countryFlag: String,
    @SerialName("track")
    val track: String,
    @SerialName("trackScheme")
    val tracScheme: String?,
    @SerialName("firstPracticeTime")
    val firstPracticeTime: String,
    @SerialName("secondPracticeTime")
    val secondPracticeTime: String? = null,
    @SerialName("thirdPracticeTime")
    val thirdPracticeTime: String,
    @SerialName("sprintTime")
    val sprintTime: String? = null,
    @SerialName("qualificationTime")
    val qualificationTime: String,
    @SerialName("raceTime")
    val raceTime: String,
    @SerialName("polePosition")
    val polePosition: String? = null,
    @SerialName("sprintWinner")
    val sprintWinner: String? = null,
    @SerialName("winner")
    val winner: String? = null,
)