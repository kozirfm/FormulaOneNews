package ru.kozirfm.firebase.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.firebase.FirebaseHelperImpl
import ru.kozirfm.firebase_api.FirebaseHelper

@Module
interface FirebaseModule {

    @AppScope
    @Binds
    fun bindFirebaseHelper(impl: FirebaseHelperImpl): FirebaseHelper
}