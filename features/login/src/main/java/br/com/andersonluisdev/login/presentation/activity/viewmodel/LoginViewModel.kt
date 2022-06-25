package br.com.andersonluisdev.login.presentation.activity.viewmodel

import androidx.lifecycle.viewModelScope
import br.com.andersonluisdev.common.baseviewmodel.viewmodel.BaseViewModel
import br.com.andersonluisdev.domain.model.login.Login
import br.com.andersonluisdev.domain.usecase.login.SignInUseCase
import br.com.andersonluisdev.login.presentation.activity.action.LoginAction
import br.com.andersonluisdev.login.presentation.activity.state.LoginViewState
import br.com.andersonluisdev.login.presentation.dataui.LoginDataUi
import br.com.andersonluisdev.login.presentation.mapper.toLoginDataUiMapper
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginViewModel(
    private val signInUseCase: SignInUseCase
) : BaseViewModel<LoginViewState, LoginAction>(LoginViewState()) {

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                signInUseCase(email, password).collect(::handleLoginState)
            }catch (t: Throwable) {
                handleLoginGenericError()
            }
        }
    }

    private fun handleLoginButtonLoadingState() {
        setState { state ->
            state.setButtonLoginLoadingState(showLoading = true)
        }
    }

    private fun handleTryAgainButtonLoadingState() {
        setState { state ->
            state.setButtonTryAgainLoadingState(showLoading = true)
        }
    }

    private fun handleLoginState(login: Login?) {
        if (login?.success == true) {
            navigateToHome(login.toLoginDataUiMapper())
        } else {
            handleLoginError(login?.errorMessage)
        }
    }

    private fun handleLoginError(errorMessage: String?) {
        errorMessage?.let { message ->
            sendAction { LoginAction.ShowInvalidLoginToast(message) }
        }
        setState { state ->
            state.setButtonLoginLoadingState(showLoading = false)
        }
    }

    private fun handleLoginGenericError() {
        setState { state ->
            state.setGenericErrorState()
        }
    }

    fun buttonSignInClicked() {
        handleLoginButtonLoadingState()
        sendAction { LoginAction.ButtonSignInClicked }
    }

    private fun navigateToHome(login: LoginDataUi) {
        sendAction { LoginAction.NavigateToHome(login) }
    }

    fun buttonTryAgainClicked() {
        sendAction { LoginAction.ButtonTryAgainClicked }
        handleTryAgainButtonLoadingState()
    }
}
