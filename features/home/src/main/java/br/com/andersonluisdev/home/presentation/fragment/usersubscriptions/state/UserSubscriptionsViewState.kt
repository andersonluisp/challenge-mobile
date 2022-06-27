package br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.state

import br.com.andersonluisdev.common.baseviewmodel.state.ViewState
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.dataui.SubscriptionDataUi

data class UserSubscriptionsViewState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val subscriptions: List<SubscriptionDataUi>? = null,
    val isError: Boolean = false
) : ViewState {
    fun setLoadingState() = this.copy(
        isLoading = true,
        isSuccess = false,
        subscriptions = null,
        isError = false
    )

    fun setSuccessState(userSubscriptions: List<SubscriptionDataUi>) = this.copy(
        isLoading = false,
        isSuccess = true,
        subscriptions = userSubscriptions,
        isError = false
    )

    fun setGenericErrorState() = this.copy(
        isLoading = false,
        isSuccess = false,
        subscriptions = null,
        isError = true
    )
}
