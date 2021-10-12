package ru.kozirfm.core.adapterdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface AdapterDelegate {

    fun onCreateViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, items: List<Any>, position: Int)

    fun isForViewType(items: List<Any>, position: Int): Boolean

}