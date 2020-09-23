package com.peterkrauz.grimoire.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel<S : BaseViewState, A : BaseViewAction>(state: S) : ViewModel() {

    private val _stateLiveData = MutableLiveData<S>()
    val stateLiveData: LiveData<S>
        get() = _stateLiveData

    fun putState(state: S) {
        _stateLiveData.postValue(state)
    }
}
