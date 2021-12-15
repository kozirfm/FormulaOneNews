package ru.kozirfm.firebase_api.di

import ru.kozirfm.firebase_api.FirebaseHelper

interface FirebaseDependencies {
    fun getFirebaseHelper(): FirebaseHelper
}