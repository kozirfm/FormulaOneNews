package ru.kozirfm.core.adapterdelegate

import androidx.recyclerview.widget.RecyclerView

abstract class ListItemAdapterDelegate<I, VH : RecyclerView.ViewHolder> : AdapterDelegate {

    abstract fun onBindViewHolder(item: I, viewHolder: VH)
    abstract fun isForViewType(item: Any): Boolean

    override fun isForViewType(items: List<Any>, position: Int): Boolean {
        return isForViewType(items[position])
    }
    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Any>, position: Int) {
        onBindViewHolder(items[position] as I, holder as VH)
    }
}