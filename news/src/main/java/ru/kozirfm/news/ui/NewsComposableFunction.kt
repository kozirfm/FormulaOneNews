package ru.kozirfm.news.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.news.R
import ru.kozirfm.news.entity.InNews
import ru.kozirfm.uistate.UiError
import ru.kozirfm.uistate.UiLoading
import ru.kozirfm.uistate.UiSuccess
import ru.kozirfm.utils.extensions.emptyString

@Composable
@ExperimentalMaterialApi
@Suppress("UNCHECKED_CAST")
fun NewsScreen(viewModel: NewsViewModel, imageLoader: ImageLoader?) {
    val uiState = viewModel.getData().collectAsState()
    when (val state = uiState.value) {
        is UiLoading -> NewsShimmer()
        is UiSuccess<*> -> NewsModalBottomSheet(
            news = state.data as List<InNews>,
            imageLoader
        )
        is UiError -> ErrorScreen(state.message)
    }
}

@Composable
@ExperimentalMaterialApi
fun NewsModalBottomSheet(news: List<InNews>, imageLoader: ImageLoader?) {
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scope = rememberCoroutineScope()
    val article = remember { mutableStateOf(emptyString()) }
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Text(
                modifier = Modifier
                    .padding(8.dp, 0.dp)
                    .verticalScroll(
                        rememberScrollState()
                    ),
                fontSize = 16.sp,
                text = article.value
            )
        }) {
        LazyColumn {
            items(news) {
                Item(inNews = it, imageLoader = imageLoader) {
                    scope.launch {
                        article.value = it.text
                        bottomSheetState.show()
                    }
                }
            }
        }
    }
}

@Composable
fun Item(inNews: InNews, imageLoader: ImageLoader?, onItemClick: () -> Unit) {
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

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(100.dp),
                painter = painterResource(R.drawable.ic_error),
                contentDescription = emptyString()
            )
            Text(fontSize = 24.sp, text = message)
        }
    }
}
