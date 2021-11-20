package ru.kozirfm.image_loader.di

import ru.kozirfm.image_loader.ImageLoader

interface ImageLoaderDependencies {
    fun getImageLoader(): ImageLoader
}