package br.com.andersonluisdev.home.presentation.fragment.myprofile.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.andersonluisdev.common.baseviewmodel.viewmodel.BaseViewModel
import br.com.andersonluisdev.domain.model.profile.UserProfile
import br.com.andersonluisdev.domain.usecase.userprofile.GetUserProfileUseCase
import br.com.andersonluisdev.home.presentation.fragment.myprofile.action.UserProfileAction
import br.com.andersonluisdev.home.presentation.fragment.myprofile.mapper.toUserProfileDataUiMapper
import br.com.andersonluisdev.home.presentation.fragment.myprofile.state.UserProfileViewState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserProfileViewModel(
    private val getUserProfileUseCase: GetUserProfileUseCase
) : BaseViewModel<UserProfileViewState, UserProfileAction>(
    UserProfileViewState()
) {

    init {
        getUserProfile()
    }

    private fun getUserProfile() {
        handleLoadingState()
        viewModelScope.launch {
            try {
                getUserProfileUseCase().collect(::handleProfileState)
            }catch (t: Throwable) {
                Log.d("Challenge", t.stackTraceToString())
                handleGenericErrorState()
            }
        }
    }

    private fun handleLoadingState() {
        setState { state ->
            state.setLoadingState()
        }
    }

    private fun handleProfileState(userProfile: UserProfile?) {
        if (userProfile?.success == true) {
            setState { state ->
                state.setSuccessState(userProfile.toUserProfileDataUiMapper())
            }
        } else {
            handleGenericErrorState()
        }
    }

    private fun handleGenericErrorState() {
        setState { state ->
            state.setGenericErrorState()
        }
    }

    fun logout() {
        sendAction {
            UserProfileAction.Logout
        }
    }

    fun tryAgainClicked() {
        setState {
            initialState
        }
        getUserProfile()
    }
}
