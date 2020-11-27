package com.peterkrauz.grimoire.presentation.home.arcdetail

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peterkrauz.grimoire.common.base.BaseViewModel
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.domain.entity.ArcRepository
import com.peterkrauz.grimoire.presentation.home.errors.ArcNotFoundException
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ArcDetailViewModel @ViewModelInject constructor(
    private val arcRepository: ArcRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel<ArcDetailState>() {

    override var state = ArcDetailState.IDLE
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    private val _arcLiveData = MutableLiveData<Arc>()
    val arcLiveData: LiveData<Arc>
        get() = _arcLiveData

    fun loadArc() {
        perform(ArcDetailState.LOADING, ArcDetailState.IDLE) {
            val arcId = savedStateHandle.get<Long>("arcId") ?: throw ArcNotFoundException
            _arcLiveData.postValue(arcRepository.findById(arcId))
        }
    }

    override fun handleCoroutineError(ctx: CoroutineContext, error: Throwable) {
        errorLiveEvent.call()
    }
}
