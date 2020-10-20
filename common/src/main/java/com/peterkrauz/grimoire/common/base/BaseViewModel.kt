package com.peterkrauz.grimoire.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel<S> : ViewModel() {

    abstract var state: S

    protected val _stateLiveData = MutableLiveData<S>()
    val stateLiveData: LiveData<S>
        get() = _stateLiveData

    private val errorHandler by lazy { CoroutineExceptionHandler(::handleCoroutineError) }

    abstract fun handleCoroutineError(ctx: CoroutineContext, error: Throwable)

    protected fun <IS : S, ES : S> perform(
        initialState: IS,
        endState: ES,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(errorHandler) {
            state = initialState
            block()
            state = endState
        }
    }
}
