package ru.kozirfm.news.ui

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import ru.kozirfm.core.adapterdelegate.ListItemAdapterDelegate
import ru.kozirfm.news_api.entities.InNews

class NewsRecyclerViewAdapter : ListItemAdapterDelegate<InNews, NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(
            ComposeView(parent.context)
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_news, parent, false)
        )
    }

    override fun onBindViewHolder(item: InNews, viewHolder: NewsViewHolder) {
        viewHolder.bind(item)
    }

    override fun isForViewType(item: Any): Boolean {
        return item is InNews
    }

}