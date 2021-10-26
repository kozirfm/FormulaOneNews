package ru.kozirfm.news.ui

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.RecyclerView
import ru.kozirfm.core.adapterdelegate.ListItemAdapterDelegate
import ru.kozirfm.news_api.entities.InNews

class NewsRecyclerViewAdapter(val onItemClick: (inNews: InNews) -> Unit) :
    ListItemAdapterDelegate<InNews, NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(
            ComposeView(parent.context)
        ){
            onItemClick(it)
        }
    }

    override fun onBindViewHolder(item: InNews, viewHolder: NewsViewHolder) {
        viewHolder.bind(item)
    }

    override fun isForViewType(item: Any): Boolean {
        return item is InNews
    }

}