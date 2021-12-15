package ru.kozirfm.image_loader_api.di

import ru.kozirfm.image_loader_api.ImageLoader

interface ImageLoaderDependencies {
    fun getImageLoader(): ImageLoader
}