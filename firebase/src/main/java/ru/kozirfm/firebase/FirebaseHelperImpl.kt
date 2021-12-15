package ru.kozirfm.firebase

import ru.kozirfm.firebase.Constants.FIREBASE_TOKEN
import ru.kozirfm.firebase_api.FirebaseHelper
import ru.kozirfm.persistent_storage_api.PersistentStorage
import javax.inject.Inject

class FirebaseHelperImpl
@Inject
constructor(
    private val persistentStorage: PersistentStorage
) : FirebaseHelper {

    override fun getToken(): String {
        return persistentStorage.load(FIREBASE_TOKEN)
    }
}