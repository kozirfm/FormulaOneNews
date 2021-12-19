package ru.kozirfm.core_api.uistate

sealed class UiState
object UiLoading : UiState()
class UiSuccess<T>(val data: T) : UiState()
class UiError(val message: String) : UiState()