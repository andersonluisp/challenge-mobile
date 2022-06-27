package br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.andersonluisdev.common.baseviewmodel.viewmodel.BaseViewModel
import br.com.andersonluisdev.domain.model.profile.Order
import br.com.andersonluisdev.domain.usecase.usersubscriptions.GetUserSubscriptionsUseCase
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.action.UserSubscriptionsAction
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.mapper.toSubscriptionDataUiMapper
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.state.UserSubscriptionsViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UserSubscriptionsViewModel(
    private val getUserSubscriptionsUseCase: GetUserSubscriptionsUseCase
) : BaseViewModel<UserSubscriptionsViewState, UserSubscriptionsAction>(UserSubscriptionsViewState()) {

    init {
        getUserSubscriptions()
    }

    private fun getUserSubscriptions() {
        handleLoadingState()
        viewModelScope.launch {
            try {
                getUserSubscriptionsUseCase().collect(::handleGetSubscriptionsState)
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

    private fun handleGetSubscriptionsState(userSubscriptions: List<Order>?) {
        userSubscriptions?.let { subscriptionsList ->
            if (subscriptionsList.isNotEmpty()) {
                if (subscriptionsList[0].success == false) {
                    handleGenericErrorState()
                } else {
                    setState { state ->
                        state.setSuccessState(subscriptionsList.map { it.toSubscriptionDataUiMapper() })
                    }
                }
            }
        }
    }

    private fun handleGenericErrorState() {
        setState { state ->
            state.setGenericErrorState()
        }
    }

    fun tryAgainClicked() {
        setState {
            initialState
        }
        getUserSubscriptions()
    }
}
