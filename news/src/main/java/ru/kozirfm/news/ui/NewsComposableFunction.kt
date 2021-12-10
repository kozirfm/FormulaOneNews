package ru.kozirfm.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ru.kozirfm.news.entity.InNews
import ru.kozirfm.utils.extensions.emptyString

@Preview
@Composable
fun Bind() {
    Item(
        inNews = InNews(
            1,
            "12 октября 12:13",
            "Фернандо Алонсо: «Читал, что я не фанат Хэмилтона, но «Ред Булл» придется справляться в одиночку. Я веду свою гонку»",
            "",
            "",
            emptyList()
        )
    ) {}
}

@ExperimentalMaterialApi
@Composable
fun NewsModalBottomSheet(news: List<InNews>) {
    val state =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    val article = remember { mutableStateOf(emptyString()) }
    ModalBottomSheetLayout(
        sheetState = state,
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
                Item(inNews = it) {
                    scope.launch {
                        article.value = it.text
                        state.show()
                    }
                }
            }
        }
    }
}

@Composable
fun Item(inNews: InNews, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .clickable {
                onItemClick()
            },
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                fontSize = 16.sp,
                text = inNews.title
            )
            Divider(
                Modifier
                    .padding(0.dp, 4.dp)
                    .background(Color.Gray)
            )
            Text(text = inNews.date)
        }
    }
}