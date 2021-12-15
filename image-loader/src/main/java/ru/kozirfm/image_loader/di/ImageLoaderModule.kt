package ru.kozirfm.image_loader.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.di.annotation.AppScope
import ru.kozirfm.image_loader.ImageLoaderImpl
import ru.kozirfm.image_loader_api.ImageLoader

@Module
class ImageLoaderModule {

    @ru.kozirfm.di.annotation.AppScope
    @Provides
    fun provideImageLoader(): ImageLoader {
        return ImageLoaderImpl()
    }
}