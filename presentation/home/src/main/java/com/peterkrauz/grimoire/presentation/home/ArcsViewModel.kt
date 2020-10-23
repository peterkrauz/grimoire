package com.peterkrauz.grimoire.presentation.home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.peterkrauz.grimoire.common.base.BaseViewModel
import com.peterkrauz.grimoire.common.presentation.SingleLiveEvent
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.domain.entity.ArcRepository
import kotlin.coroutines.CoroutineContext

class ArcsViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val arcRepository: ArcRepository
) : BaseViewModel<ArcsState>() {

    override var state = ArcsState.IDLE
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    val errorLiveEvent = SingleLiveEvent<Unit>()

    private val _arcsLiveData = MutableLiveData<List<Arc>>()
    val arcsLiveData: LiveData<List<Arc>>
        get() = _arcsLiveData

    fun fetchArcs() {
        perform(ArcsState.LOADING, ArcsState.IDLE) {
            _arcsLiveData.postValue(arcRepository.findAll())
        }
    }

    override fun handleCoroutineError(ctx: CoroutineContext, error: Throwable) {
        errorLiveEvent.call()
    }
}
