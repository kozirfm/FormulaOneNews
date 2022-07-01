package ru.kozirfm.calendar_api.mapper

import ru.kozirfm.calendar_api.entity.InCalendar
import ru.kozirfm.calendar_api.entity.OutCalendar
import ru.kozirfm.utils.mapper.BaseMapper

object ToInCalendarMapper : BaseMapper<OutCalendar, InCalendar> {
    override fun map(response: OutCalendar): InCalendar {
        return with(response) {
            InCalendar(
                date = date,
                country = country,
                countryFlag = countryFlag,
                track = track,
                trackScheme = tracScheme,
                firstPracticeTime = firstPracticeTime,
                secondPracticeTime = secondPracticeTime,
                thirdPracticeTime = thirdPracticeTime,
                sprintTime = sprintTime,
                qualificationTime = qualificationTime,
                raceTime = raceTime,
                polePosition = polePosition,
                sprintWinner = sprintWinner,
                winner = winner
            )
        }
    }
}