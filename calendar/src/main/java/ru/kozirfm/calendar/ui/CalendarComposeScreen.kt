package ru.kozirfm.calendar.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kozirfm.calendar_api.entity.InCalendar
import ru.kozirfm.core.presentation.uistate.UiError
import ru.kozirfm.core.presentation.uistate.UiLoading
import ru.kozirfm.core.presentation.uistate.UiSuccess
import ru.kozirfm.image_loader_api.ImageLoader
import ru.kozirfm.utils.extensions.emptyString
import ru.kozirfm.design_system.R as RDesign

@Composable
@Suppress("UNCHECKED_CAST")
fun CalendarScreen(viewModel: CalendarViewModel, imageLoader: ImageLoader?) {
    val uiState by remember { viewModel.getData() }.collectAsState()
    when (uiState) {
        is UiLoading -> CalendarShimmer()
        is UiSuccess<*> -> {
            CalendarList(
                calendar = (uiState as UiSuccess<*>).data as List<InCalendar>,
                imageLoader = imageLoader
            )
        }
        is UiError -> ErrorScreen(message = (uiState as UiError).message)
    }

}

@Composable
fun CalendarList(calendar: List<InCalendar>, imageLoader: ImageLoader?) {
    LazyColumn {
        items(calendar) {
            CalendarItem(inCalendar = it, imageLoader = imageLoader)
        }
    }
}

@Composable
fun CalendarItem(inCalendar: InCalendar, imageLoader: ImageLoader?) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            imageLoader?.let {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = imageLoader.load(any = inCalendar.countryFlag),
                        contentDescription = emptyString(),
                        modifier = Modifier
                            .width(36.dp)
                            .clip(RoundedCornerShape(0f))
                            .background(color = Color.Black)
                            .alpha(0.95f)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp),
                        text = inCalendar.country,
                        fontSize = 16.sp
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = inCalendar.date,
                        textAlign = TextAlign.End,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.size(4.dp))
                Row {
                    Image(
                        painter = imageLoader.load(any = inCalendar.trackScheme),
                        contentDescription = emptyString(),
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color.Gray)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .align(Alignment.CenterVertically),
                        text = inCalendar.track,
                        fontSize = 24.sp
                    )
                }

            }
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
fun CalendarShimmer() {
    Column {
        repeat(8) {
            ShimmerAnimation()
        }

    }
}

@Composable
fun ShimmerItem(brush: Brush) {
    // Column composable containing spacer shaped like a rectangle,
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