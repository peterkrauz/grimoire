package com.peterkrauz.grimoire.common

import androidx.lifecycle.ViewModel
import com.peterkrauz.grimoire.common.presentation.SingleLiveEvent

class MainViewModel : ViewModel() {

    val arcCreatedLiveEvent = SingleLiveEvent<Unit>()

    fun onArcCreated() = arcCreatedLiveEvent.call()
}
