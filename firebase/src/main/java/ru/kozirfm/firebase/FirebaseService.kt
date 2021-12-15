package ru.kozirfm.firebase

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import ru.kozirfm.core_api.preferences.PersistentStorage
import ru.kozirfm.firebase.Constants.FIREBASE_TOKEN
import ru.kozirfm.firebase.di.FirebaseFeature
import javax.inject.Inject

class FirebaseService : FirebaseMessagingService() {

    init {
        FirebaseFeature.getComponent().inject(this)
    }

    @set:Inject
    var persistentStorage: PersistentStorage? = null

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        persistentStorage?.save(FIREBASE_TOKEN, token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        //Get data from message when app onResumed
        println(message.data)
    }

}