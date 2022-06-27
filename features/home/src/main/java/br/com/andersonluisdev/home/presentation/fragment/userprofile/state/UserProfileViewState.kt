package br.com.andersonluisdev.home.presentation.fragment.userprofile.state

import br.com.andersonluisdev.common.baseviewmodel.state.ViewState
import br.com.andersonluisdev.home.presentation.fragment.userprofile.dataui.UserProfileDataUi

data class UserProfileViewState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val profileData: UserProfileDataUi? = null,
    val isError: Boolean = false
) : ViewState {

    fun setLoadingState() = this.copy(
        isLoading = true,
        isSuccess = false,
        profileData = null,
        isError = false
    )

    fun setSuccessState(userProfile: UserProfileDataUi) = this.copy(
        isLoading = false,
        isSuccess = true,
        profileData = userProfile,
        isError = false
    )

    fun setGenericErrorState() = this.copy(
        isLoading = false,
        isSuccess = false,
        profileData = null,
        isError = true
    )
}
