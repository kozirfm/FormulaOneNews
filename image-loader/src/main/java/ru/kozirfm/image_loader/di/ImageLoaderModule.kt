package ru.kozirfm.image_loader.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.image_loader.ImageLoader
import ru.kozirfm.image_loader.ImageLoaderImpl

@Module
class ImageLoaderModule {

    @Provides
    fun provideImageLoader(): ImageLoader {
        return ImageLoaderImpl()
    }
}