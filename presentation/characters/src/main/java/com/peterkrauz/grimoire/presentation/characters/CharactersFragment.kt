package com.peterkrauz.grimoire.presentation.characters

import android.media.MediaPlayer
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {

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

