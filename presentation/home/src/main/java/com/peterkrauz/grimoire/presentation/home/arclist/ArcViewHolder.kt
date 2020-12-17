package com.peterkrauz.grimoire.presentation.home.arclist

import android.view.View
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.peterkrauz.grimoire.common.extension.captureTouchEventsFrom
import com.peterkrauz.grimoire.domain.entity.arc.Arc
import kotlinx.android.synthetic.main.item_arc.view.*

class ArcViewHolder(view: View) : ViewHolder(view) {
    fun bind(arc: Arc, onArcClick: (Arc) -> Unit) {
        itemView.run {
            textViewArcName.text = arc.title
            textViewArcDescription.text = arc.description
            buttonReadMore.setOnClickListener { onArcClick(arc) }
            buttonReadMore.captureTouchEventsFrom(cardViewArc)
            ViewCompat.setTransitionName(cardViewArc, "arc_${arc.id}")
        }
    }
}
