package br.com.andersonluisdev.login.presentation.activity.state

import br.com.andersonluisdev.common.baseviewmodel.state.ViewState

data class LoginViewState(
    val isLoginButtonLoading: Boolean = false,
    val isTryAgainButtonLoading: Boolean = false,
    val isLoginError: Boolean = false,
): ViewState {

    fun setButtonLoginLoadingState(showLoading: Boolean) = this.copy(
        isLoginButtonLoading = showLoading,
        isTryAgainButtonLoading = false,
        isLoginError = false,
    )

    fun setButtonTryAgainLoadingState(showLoading: Boolean) = this.copy(
        isLoginButtonLoading = false,
        isTryAgainButtonLoading = showLoading,
        isLoginError = false,
    )

    fun setGenericErrorState() = this.copy(
        isLoginButtonLoading = false,
        isTryAgainButtonLoading = false,
        isLoginError = true,
    )

}
