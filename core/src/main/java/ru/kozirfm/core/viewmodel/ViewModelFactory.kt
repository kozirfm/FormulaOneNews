package ru.kozirfm.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.kozirfm.core.annotation.PerFeature
import javax.inject.Inject
import javax.inject.Provider

@Suppress("UNCHECKED_CAST")
@PerFeature
class ViewModelFactory @Inject constructor(
    private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModels[modelClass]?.get() as? T ?: throw IllegalArgumentException()
    }

}