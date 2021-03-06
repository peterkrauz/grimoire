package com.peterkrauz.grimoire.presentation.home.arclist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.peterkrauz.grimoire.common.extension.inflate
import com.peterkrauz.grimoire.domain.entity.arc.Arc
import com.peterkrauz.grimoire.presentation.home.R

class ArcsAdapter(
    private val onArcClick: (Arc) -> Unit
) : ListAdapter<Arc, ArcViewHolder>(ArcDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArcViewHolder {
        return ArcViewHolder(parent.inflate(R.layout.item_arc))
    }

    override fun onBindViewHolder(holder: ArcViewHolder, position: Int) {
        holder.bind(getItem(position), onArcClick)
    }

    fun getItemAt(position: Int): Arc = getItem(position)

    private object ArcDiffCallback : DiffUtil.ItemCallback<Arc>() {
        override fun areItemsTheSame(old: Arc, new: Arc): Boolean {
            return old.id == new.id
        }

        override fun areContentsTheSame(old: Arc, new: Arc): Boolean {
            return old == new
        }
    }
}
