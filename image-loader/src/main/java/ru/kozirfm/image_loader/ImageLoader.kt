package ru.kozirfm.image_loader

import android.widget.ImageView

interface ImageLoader {
    fun load(imageView: ImageView, any: Any)
    fun clear()
}