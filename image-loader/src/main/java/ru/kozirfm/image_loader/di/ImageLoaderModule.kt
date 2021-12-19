package ru.kozirfm.image_loader.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.image_loader.ImageLoaderImpl
import ru.kozirfm.image_loader_api.ImageLoader

@Module
class ImageLoaderModule {

    @AppScope
    @Provides
    fun provideImageLoader(): ImageLoader {
        return ImageLoaderImpl()
    }
}