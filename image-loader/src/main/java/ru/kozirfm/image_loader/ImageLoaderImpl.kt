package ru.kozirfm.image_loader

import android.widget.ImageView
import coil.loadAny
import coil.request.Disposable

class ImageLoaderImpl : ImageLoader {

    private val disposable = mutableListOf<Disposable>()

    override fun load(imageView: ImageView, any: Any) {
        imageView.loadAny(any)
            .also { disposable.add(it) }
    }

    override fun clear() {
        disposable.forEach { it.dispose() }
    }

}