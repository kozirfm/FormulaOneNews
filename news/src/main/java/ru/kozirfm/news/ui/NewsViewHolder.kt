package ru.kozirfm.news.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import ru.kozirfm.news.entity.InNews

class NewsViewHolder(
    private val composeView: ComposeView,
    val onItemClick: (inNews: InNews) -> Unit
) : RecyclerView.ViewHolder(composeView) {

    init {
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
    }

    fun bind(inNews: InNews) {
        composeView.apply {
            setContent {
                Item(inNews = inNews) {
                    onItemClick(inNews)
                }
            }
        }
    }
}

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

@Preview
@Composable
fun ContentPreview() {
    Content(text = "\nПилот «Астон Мартин» Себастьян Феттель с высокой долей вероятности начнет Гран-при США с последнего ряда стартовой решетки.\n\nФеттель сообщил, что перед началом уик-энда команда приняла решение установить на его болид новый двигатель, в связи с чем Себастьяна ждет штраф за перерасход элементов силовой установки.\n")
}

@Composable
fun Content(text: String) {
    Card(
        shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 16.dp, 0.dp, 0.dp)
            .clickable {

            },
        elevation = 4.dp
    ) {
        Text(
            modifier = Modifier.padding(8.dp, 8.dp, 8.dp, 16.dp),
            text = text.trimIndent()
        )
    }
}