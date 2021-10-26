package ru.kozirfm.core.base

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.kozirfm.navigation_api.RootDirections
import javax.inject.Inject

class SplashViewModel @Inject constructor(private val rootDirections: RootDirections) :
    BaseViewModel() {

    init {
        viewModelScope.launch {
            navigateTo(rootDirections.toMainFragment())
        }
    }

}