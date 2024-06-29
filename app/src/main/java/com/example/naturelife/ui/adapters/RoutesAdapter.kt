package com.example.naturelife.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.naturelife.R
import com.example.naturelife.domain.model.Route
import com.example.naturelife.utils.DateUtil.toDateString

class RoutesAdapter : Adapter<RouteViewHolder>() {
    var data: List<Route> = listOf()
        set(value) {
            val callback = RoutesDiffCallback(field, value)
            field = value.toList()
            val diff = DiffUtil.calculateDiff(callback)
            diff.dispatchUpdatesTo(this)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RouteViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RouteViewHolder(layoutInflater.inflate(R.layout.item_track, parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RouteViewHolder, position: Int) {
        holder.bind(data[position])
    }

}

class RouteViewHolder(itemView: View) : ViewHolder(itemView) {
    val dateText: TextView = itemView.findViewById(R.id.date_text)
    val image: ImageView = itemView.findViewById(R.id.track_image)

    fun bind(route: Route) {
        dateText.text = itemView.context.getString(R.string.stroll_with_date, route.date.toDateString())
    }
}