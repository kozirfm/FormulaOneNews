package ru.kozirfm.news_detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news_api.entity.InNews
import ru.kozirfm.utils.extensions.emptyString

@Composable
fun NewsDetailScreen(viewModel: NewsDetailViewModel, imageLoader: ImageLoader?, id: String?) {
    val uiState by remember { viewModel.getData(id?.toLong()) }.collectAsState()
    when (uiState) {
        is UiSuccess<*> -> {
            val news = (uiState as UiSuccess<*>).data as InNews
            imageLoader?.let { painter ->
                LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
                    news.apply {
                        item { NewsDetailText(text = text) }
                        images?.let { images ->
                            items(images.count()) { index ->
                                NewsDetailImage(painter = painter, images = images, index = index)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun NewsDetailText(text: String) {
    Text(
        text,
        fontSize = 18.sp,
    )
}

@Composable
fun NewsDetailImage(painter: ImageLoader, images: List<String>, index: Int) {
    Image(
        painter = painter.load(any = images[index]),
        contentDescription = emptyString(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.FillWidth
    )
}