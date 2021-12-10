package ru.kozirfm.image_loader

import android.widget.ImageView
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.rememberImagePainter
import coil.loadAny

class ImageLoaderImpl : ImageLoader {

    override fun load(imageView: ImageView, any: Any) {
        imageView.loadAny(any)
    }

    @Composable
    override fun load(any: Any?): Painter {
        return rememberImagePainter(data = any)
    }
}