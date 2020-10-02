package com.peterkrauz.grimoire.presentation.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.peterkrauz.grimoire.common.base.BaseViewModel
import kotlin.coroutines.CoroutineContext

class ArcsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel<ArcsState>() {

    override var state = ArcsState.IDLE
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    override fun handleCoroutineError(ctx: CoroutineContext, error: Throwable) {
    }
}
