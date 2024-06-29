package com.example.naturelife.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.naturelife.domain.model.Route

class RoutesDiffCallback(
    private val oldItems: List<Route>,
    private val newItems: List<Route>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldItems.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].date == newItems[newItemPosition].date
    }
}