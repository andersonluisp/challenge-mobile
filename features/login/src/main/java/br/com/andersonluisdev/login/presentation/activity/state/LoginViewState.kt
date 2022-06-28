package br.com.andersonluisdev.login.presentation.activity.state

import br.com.andersonluisdev.common.baseviewmodel.state.ViewState

data class LoginViewState(
    val isLoginButtonLoading: Boolean = false,
    val isLoginError: Boolean = false,
): ViewState {

    fun setButtonLoginLoadingState(showLoading: Boolean) = this.copy(
        isLoginButtonLoading = showLoading,
        isLoginError = false,
    )

    fun setGenericErrorState() = this.copy(
        isLoginButtonLoading = false,
        isLoginError = true,
    )

}
