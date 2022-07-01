package ru.kozirfm.calendar_api.entity

data class InCalendar(
    val date: String,
    val country: String,
    val countryFlag: String,
    val track: String,
    val trackScheme: String?,
    val firstPracticeTime: String,
    val secondPracticeTime: String?,
    val thirdPracticeTime: String,
    val sprintTime: String?,
    val qualificationTime: String,
    val raceTime: String,
    val polePosition: String?,
    val sprintWinner: String?,
    val winner: String?,
)