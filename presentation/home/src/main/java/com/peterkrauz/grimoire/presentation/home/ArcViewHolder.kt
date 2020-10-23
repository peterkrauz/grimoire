package com.peterkrauz.grimoire.presentation.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.peterkrauz.grimoire.domain.entity.Arc
import kotlinx.android.synthetic.main.item_arc.view.*

class ArcViewHolder(view: View) : ViewHolder(view) {
    fun bind(arc: Arc) {
        itemView.run {
            textViewArcName.text = arc.title
            textViewArcDescription.text = arc.description
        }
    }
}
