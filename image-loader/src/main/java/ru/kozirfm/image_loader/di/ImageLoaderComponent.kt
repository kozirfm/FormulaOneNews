package ru.kozirfm.image_loader.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.image_loader_api.di.ImageLoaderDependencies

@AppScope
@Component(modules = [ImageLoaderModule::class])
interface ImageLoaderComponent : ImageLoaderDependencies