package ru.kozirfm.core.adapterdelegate

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CompositeAdapter(
    private val delegatesManager: AdapterDelegatesManager,
    private val items: List<Any>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegatesManager.onCreateViewHolder(parent, viewType)
    }
    
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(items, position, holder)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(items, position)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

}