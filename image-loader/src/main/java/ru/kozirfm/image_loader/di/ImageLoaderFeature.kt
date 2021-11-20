package ru.kozirfm.image_loader.di

object ImageLoaderFeature {
    fun getComponent(): ImageLoaderComponent {
        return DaggerImageLoaderComponent.create()
    }
}