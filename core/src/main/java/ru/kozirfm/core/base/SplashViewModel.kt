package ru.kozirfm.core.base

import ru.kozirfm.navigation_api.NavigateRootDirection
import javax.inject.Inject

class SplashViewModel
@Inject
constructor(private val navigateRootDirection: NavigateRootDirection) : BaseViewModel() {

    init {
        navigateTo(navigateRootDirection.toMainFragment())
    }

}