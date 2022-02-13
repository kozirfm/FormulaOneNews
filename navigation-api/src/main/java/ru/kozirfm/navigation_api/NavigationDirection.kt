package ru.kozirfm.navigation_api

import android.os.Bundle

interface NavigationDirection {
    fun getActionIds(): Int
    fun getArguments(): Bundle
}