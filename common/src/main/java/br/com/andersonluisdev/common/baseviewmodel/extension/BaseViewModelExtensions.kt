package br.com.andersonluisdev.common.baseviewmodel.extension

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.andersonluisdev.common.baseviewmodel.action.ViewAction
import br.com.andersonluisdev.common.baseviewmodel.state.ViewState
import br.com.andersonluisdev.common.baseviewmodel.viewmodel.BaseViewModel

fun <State : ViewState, Action : ViewAction> AppCompatActivity.onStateChange(
    viewModel: BaseViewModel<State, Action>,
    handleStates: (State) -> Unit
) {
    viewModel.state.observe(this) { state -> handleStates(state as State) }
}

fun <State : ViewState, Action : ViewAction> AppCompatActivity.onAction(
    viewModel: BaseViewModel<State, Action>,
    handleStates: (Action) -> Unit
) {
    viewModel.action.observe(this) { action -> handleStates(action as Action) }
}

fun <State : ViewState, Action : ViewAction> Fragment.onStateChange(
    viewModel: BaseViewModel<State, Action>,
    handleStates: (State) -> Unit
) {
    viewModel.state.observe(viewLifecycleOwner) { state -> handleStates(state as State) }
}

fun <State : ViewState, Action : ViewAction> Fragment.onAction(
    viewModel: BaseViewModel<State, Action>,
    handleStates: (Action) -> Unit
) {
    viewModel.action.observe(viewLifecycleOwner) { action -> handleStates(action as Action) }
}
