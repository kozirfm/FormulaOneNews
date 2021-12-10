package ru.kozirfm.image_loader.di

import dagger.Component
import ru.kozirfm.core.di.annotation.AppScope

@AppScope
@Component(modules = [ImageLoaderModule::class])
interface ImageLoaderComponent : ImageLoaderDependencies