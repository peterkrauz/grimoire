package com.peterkrauz.grimoire.presentation.notes

import android.media.MediaPlayer
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment(R.layout.fragment_notes) {

    private var mediaPlayer: MediaPlayer? = null

    override fun onResume() {
        super.onResume()
//        mediaPlayer = MediaPlayer.create(this, R.raw.arcs_tab_sound).apply {
//            setOnCompletionListener { mediaPlayer?.release() }
//        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.release()
    }
}

