package ru.kozirfm.core.adapterdelegate

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

class AdapterDelegatesManager(vararg delegates: AdapterDelegate) {

    private val delegates: SparseArrayCompat<AdapterDelegate> = SparseArrayCompat()

    init {
        for (element in delegates) {
            addDelegate(element)
        }
    }

    private fun addDelegate(delegate: AdapterDelegate) {
        var viewType = delegates.size()
        while (delegates[viewType] != null) {
            viewType++
        }
        delegates.put(viewType, delegate)
    }

    fun getItemViewType(items: List<Any>, position: Int): Int {
        val delegatesCount = delegates.size()
        for (i in 0 until delegatesCount) {
            val delegate: AdapterDelegate = delegates.valueAt(i)
            if (delegate.isForViewType(items, position)) {
                return delegates.keyAt(i)
            }
        }
        throw IllegalArgumentException()
    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val delegate: AdapterDelegate = delegates[viewType] ?: throw IllegalArgumentException()
        return delegate.onCreateViewHolder(parent)
    }

    fun onBindViewHolder(items: List<Any>, position: Int, holder: RecyclerView.ViewHolder) {
        val delegate: AdapterDelegate =
            delegates[holder.itemViewType] ?: throw IllegalArgumentException()
        delegate.onBindViewHolder(holder, items, position)

    }
}