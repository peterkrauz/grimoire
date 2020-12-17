package com.peterkrauz.grimoire.presentation.home.eventlist

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.peterkrauz.grimoire.domain.entity.event.Event
import kotlinx.android.synthetic.main.item_arc_description.view.*

sealed class EventListViewHolder(view: View) : ViewHolder(view)

class ArcDescriptionViewHolder(view: View) : EventListViewHolder(view) {
    fun bind(description: String) {
        itemView.textViewArcDescription.text = description
    }
}

class EventViewHolder(view: View) : EventListViewHolder(view) {

    fun bind(event: Event, onEventClick: (Event) -> Unit) {
        itemView.run {
        }
    }
}
