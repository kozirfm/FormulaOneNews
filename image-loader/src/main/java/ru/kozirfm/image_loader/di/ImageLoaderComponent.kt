package ru.kozirfm.image_loader.di

import dagger.Component
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi

@AppScope
@Component(modules = [ImageLoaderModule::class])
interface ImageLoaderComponent : ImageLoaderFeatureApi