package com.peterkrauz.grimoire.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

abstract class BaseViewModel<out S : BaseViewState, A : BaseViewAction>(state: S) : ViewModel() {

    private var state by Delegates.observable(state, ::onStateChanged)

    private val _stateLiveData = MutableLiveData<S>()
    val stateLiveData: LiveData<out S>
        get() = _stateLiveData

    private val coroutinesErrorHandler by lazy { CoroutineExceptionHandler(::handleError) }

    fun performAction(action: A) {
        state = reduceState(action)
    }

    abstract fun loadData()

    abstract fun handleError(context: CoroutineContext, error: Throwable)

    protected abstract fun reduceState(action: A): S

    private fun onStateChanged(property: KProperty<*>, oldState: S, newState: S) {
        _stateLiveData.postValue(newState)
    }
}
