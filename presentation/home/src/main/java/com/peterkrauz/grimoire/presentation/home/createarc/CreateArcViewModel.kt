package com.peterkrauz.grimoire.presentation.home.createarc

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.peterkrauz.grimoire.common.base.BaseViewModel
import com.peterkrauz.grimoire.domain.usecase.CreateArcUseCase
import kotlin.coroutines.CoroutineContext

class CreateArcViewModel @ViewModelInject constructor(
    private val createArcUseCase: CreateArcUseCase,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel<CreateArcState>() {

    override var state: CreateArcState = CreateArcState.WAITING
        set(value) {
            field = value
            _stateLiveData.postValue(value)
        }

    private var title: String? = null
        set(value) {
            field = value
            refreshState()
        }

    private var description: String? = null
        set(value) {
            field = value
            refreshState()
        }

    fun onTitleChanged(title: String?) {
        this.title = title
    }

    fun onDescriptionChanged(description: String?) {
        this.description = description
    }

    fun onCreateClicked() {
        val safeTitle = title ?: return
        val safeDescription = description ?: return
        perform(CreateArcState.CREATING, CreateArcState.FINISHED) {
            createArcUseCase.createArc(safeTitle, safeDescription)
        }
    }

    private fun refreshState() {
        val ready = !title.isNullOrBlank() && !description.isNullOrBlank()
        state = when {
            ready -> CreateArcState.READY
            else -> CreateArcState.WAITING
        }
    }

    override fun handleCoroutineError(ctx: CoroutineContext, error: Throwable) {
        refreshState()
        errorLiveEvent.call()
    }
}
