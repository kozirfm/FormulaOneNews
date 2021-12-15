package ru.kozirfm.image_loader_api

import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

interface ImageLoader {
    fun load(imageView: ImageView, any: Any)
    @Composable
    fun load(any: Any?): Painter
}