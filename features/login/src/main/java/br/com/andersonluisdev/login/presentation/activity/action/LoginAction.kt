package br.com.andersonluisdev.login.presentation.activity.action

import br.com.andersonluisdev.common.baseviewmodel.action.ViewAction
import br.com.andersonluisdev.login.presentation.dataui.LoginDataUi

sealed class LoginAction : ViewAction {
    data class NavigateToHome(val login: LoginDataUi) : LoginAction()
    data class ShowInvalidLoginToast(val errorMessage: String) : LoginAction()
    object ButtonSignInClicked : LoginAction()
    object ButtonTryAgainClicked : LoginAction()
}
