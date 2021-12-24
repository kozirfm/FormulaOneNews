package ru.kozirfm.image_loader.di

import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import javax.inject.Inject

class ImageLoaderFeature @Inject constructor() {

    private val _api: ImageLoaderFeatureApi = DaggerImageLoaderComponent
        .create()
        .also { imageLoaderComponent = it }

    fun getApi() = _api

    internal companion object {
        var imageLoaderComponent: ImageLoaderComponent? = null
    }
}