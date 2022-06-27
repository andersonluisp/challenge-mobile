package br.com.andersonluisdev.common.baseviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.andersonluisdev.common.baseviewmodel.action.ViewAction
import br.com.andersonluisdev.common.baseviewmodel.state.ViewState

abstract class BaseViewModel<State : ViewState, Action : ViewAction>(
    val initialState: State
) :ViewModel() {

    private val _state: MutableLiveData<State> = MutableLiveData(initialState)
    val state: LiveData<State>
        get() = _state

    private val _action: SingleEventLiveData<Action> = SingleEventLiveData()
    val action: LiveData<Action>
        get() = _action

    protected fun setState(state: (State) -> State) {
        _state.value = state(_state.value!!)
    }

    protected fun sendAction(action: () -> Action) {
        _action.value = action()
    }
}
