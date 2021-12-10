package ru.kozirfm.utils.extensions

import kotlinx.coroutines.delay

//Метод устанавливает минимальный тайм-аут после запроса для отображение шиммеринга
suspend fun <T> T.withTimeout(timeMillis: Long): T {
    delay(timeMillis)
    return this
}