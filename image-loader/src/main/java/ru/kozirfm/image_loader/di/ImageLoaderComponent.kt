package ru.kozirfm.image_loader.di

import dagger.Component

@Component(modules = [ImageLoaderModule::class])
interface ImageLoaderComponent : ImageLoaderDependencies