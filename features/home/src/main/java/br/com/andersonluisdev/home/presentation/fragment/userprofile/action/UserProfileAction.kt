package br.com.andersonluisdev.home.presentation.fragment.userprofile.action

import br.com.andersonluisdev.common.baseviewmodel.action.ViewAction

sealed class UserProfileAction : ViewAction {
    object NavigateToUserSubscriptions : UserProfileAction()
    object Logout : UserProfileAction()
}
