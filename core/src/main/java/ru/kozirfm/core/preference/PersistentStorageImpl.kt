package ru.kozirfm.core.preference

import android.content.Context
import androidx.preference.PreferenceManager
import ru.kozirfm.core_api.preferences.PersistentStorage
import ru.kozirfm.utils.extensions.emptyString
import javax.inject.Inject

class PersistentStorageImpl
@Inject
constructor(context: Context) : PersistentStorage {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    override fun save(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun load(key: String): String {
        return sharedPreferences.getString(key, emptyString()).orEmpty()
    }

}