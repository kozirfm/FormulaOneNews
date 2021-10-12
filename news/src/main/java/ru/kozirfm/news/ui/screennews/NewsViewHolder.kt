package ru.kozirfm.news.ui.screennews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView
import ru.kozirfm.news_api.entities.InNews

class NewsViewHolder(private val composeView: ComposeView) : RecyclerView.ViewHolder(composeView) {

    init {
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
    }
    fun bind(inNews: InNews) {
        composeView.setContent {
            Item(inNews = inNews)
        }
    }
}

@Preview
@Composable
fun Bind(){
    Item(inNews = InNews(
        1,
        "12 октября 12:13",
        "Фернандо Алонсо: «Читал, что я не фанат Хэмилтона, но «Ред Булл» придется справляться в одиночку. Я веду свою гонку»",
        "",
        "",
        emptyList()))
}

@Composable
fun Item(inNews: InNews){
    Card(
        modifier = Modifier.padding(16.dp, 8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = inNews.title)
            Divider(
                Modifier
                .padding(0.dp, 4.dp)
                .background(Color.Gray)
            )
            Text(text = inNews.date)
        }
    }
}