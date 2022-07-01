package ru.kozirfm.news.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiLoading
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news_api.entity.InNews
import ru.kozirfm.utils.extensions.emptyString
import ru.kozirfm.design_system.R as RDesign

@Composable
@Suppress("UNCHECKED_CAST")
fun NewsScreen(viewModel: NewsViewModel, imageLoader: ImageLoader?) {
    val uiState by remember { viewModel.getData() }.collectAsState()
    val isRefreshing by viewModel.isRefreshing.collectAsState()
    when (uiState) {
        is UiLoading -> NewsShimmer()
        is UiSuccess<*> -> {
            NewsList(
                news = (uiState as UiSuccess<*>).data as? List<InNews>,
                imageLoader = imageLoader,
                isRefreshing = isRefreshing,
                onRefresh = {
                    viewModel.getData(forceUpdate = true)
                },
                onClick = {
                    viewModel.onItemClick(it.id)
                }
            )
        }
        is UiError -> ErrorScreen((uiState as UiError).message)
    }
}

@Composable
fun NewsList(
    news: List<InNews>?,
    imageLoader: ImageLoader?,
    isRefreshing: Boolean,
    onClick: (InNews) -> Unit,
    onRefresh: () -> Unit
) {
    news?.let {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = isRefreshing),
            onRefresh = onRefresh
        ) {
            LazyColumn {
                items(news) {
                    NewsItem(inNews = it, imageLoader = imageLoader) {
                        onClick(it)
                    }
                }
            }
        }
    } ?: ErrorScreen(message = "Error")
}

@Composable
fun NewsItem(inNews: InNews, imageLoader: ImageLoader?, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .clickable {
                onItemClick()
            },
        elevation = 4.dp
    ) {
        Column {
            inNews.images?.firstOrNull()?.let { image ->
                imageLoader?.let {
                    Image(
                        painter = imageLoader.load(any = image),
                        contentDescription = emptyString(),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                }
            }
            Text(
                modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 0.dp),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp,
                text = inNews.title
            )
            Divider(
                Modifier
                    .padding(8.dp, 4.dp)
                    .background(Color.Gray)
            )
            Text(
                modifier = Modifier.padding(8.dp, 0.dp, 8.dp, 8.dp),
                text = inNews.date
            )
        }
    }
}

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(100.dp),
                painter = painterResource(RDesign.drawable.ic_error),
                contentDescription = emptyString()
            )
            Text(fontSize = 24.sp, text = message)
        }
    }
}

@Composable
fun NewsShimmer() {
    Column {
        repeat(8) {
            ShimmerAnimation()
        }
    }
}

@Composable
fun ShimmerItem(brush: Brush) {
    // Column composable comtaining spacer shaped like a rectangle,
    // set the [background]'s [brush] with the brush receiving from [ShimmerAnimation]
    // Composable which is the Animation you are gonna create.
    Card(modifier = Modifier.padding(16.dp, 8.dp), elevation = 0.dp) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(brush = brush)
        )
    }
}

@Composable
fun ShimmerAnimation() {
    /*
    Create InfiniteTransition
    which holds child animation like [Transition]
    animations start running as soon as they enter
    the composition and do not stop unless they are removed
    */
    val transition = rememberInfiniteTransition()
    val translateAnim by transition.animateFloat(
        /*
        Specify animation positions,
        initial Values 0F means it
        starts from 0 position
        */
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            // Tween Animates between values over specified [durationMillis]
            tween(durationMillis = 1200, easing = FastOutSlowInEasing),
            RepeatMode.Reverse
        )
    )
    val shimmerColorShades = listOf(
        Color.LightGray.copy(0.9f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.9f)
    )
    /*
    Create a gradient using the list of colors
    Use Linear Gradient for animating in any direction according to requirement
    start=specifies the position to start with in cartesian like system Offset(10f,10f) means x(10,0) , y(0,10)
    end = Animate the end position to give the shimmer effect using the transition created above
    */
    val brush = Brush.linearGradient(
        colors = shimmerColorShades,
        start = Offset(10f, 10f),
        end = Offset(translateAnim, translateAnim)
    )
    ShimmerItem(brush = brush)
}
