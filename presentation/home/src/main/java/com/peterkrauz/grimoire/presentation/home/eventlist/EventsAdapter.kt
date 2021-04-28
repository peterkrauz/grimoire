package com.peterkrauz.grimoire.presentation.home.eventlist

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.peterkrauz.grimoire.common.extension.inflate
import com.peterkrauz.grimoire.domain.entity.event.Event
import com.peterkrauz.grimoire.presentation.home.R

class EventsAdapter(
    private val onEventClick: (Event) -> Unit
) : ListAdapter<EventListItem, EventListViewHolder>(EventDiffCallback) {

    private var arcDescription: String? = null
        set(value) {
            field = value
            rebuildList()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        return when (viewType) {
            EventListItem.ARC_DESCRIPTION_TYPE -> ArcDescriptionViewHolder(parent.inflate(R.layout.item_arc_description))
            EventListItem.EVENT_TYPE -> EventViewHolder(parent.inflate(R.layout.item_event))
            else -> throw IllegalArgumentException("No ViewHolder found for type $viewType")
        }
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        when (holder) {
            is ArcDescriptionViewHolder -> bindArcDescription(
                holder,
                getItem(position) as ArcDescriptionItem
            )
            is EventViewHolder -> bindEvent(
                holder,
                getItem(position) as EventItem
            )
        }
    }

    private fun bindArcDescription(holder: ArcDescriptionViewHolder, item: ArcDescriptionItem) {
        holder.bind(item.description)
    }

    private fun bindEvent(holder: EventViewHolder, eventItem: EventItem) {
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).itemType
    }

    private fun rebuildList() {
    }

    fun addArcDescription(description: String) {
        val newList = mutableSetOf<EventListItem>()
        newList.add(ArcDescriptionItem(description))
        if (currentList.isNotEmpty()) newList.addAll(currentList)
        submitList(newList.toList())
    }

    private object EventDiffCallback : DiffUtil.ItemCallback<EventListItem>() {
        override fun areItemsTheSame(old: EventListItem, new: EventListItem): Boolean {
            return when {
                old is ArcDescriptionItem && new is ArcDescriptionItem -> old == new
                old is EventItem && new is EventItem -> old.event.id == new.event.id
                else -> false
            }
        }

        override fun areContentsTheSame(old: EventListItem, new: EventListItem): Boolean {
            return when {
                old is ArcDescriptionItem && new is ArcDescriptionItem -> old == new
                old is EventItem && new is EventItem -> old.event == new.event
                else -> false
            }
        }
    }
}
