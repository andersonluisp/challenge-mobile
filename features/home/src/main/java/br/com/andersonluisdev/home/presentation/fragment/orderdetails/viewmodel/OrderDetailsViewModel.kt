package br.com.andersonluisdev.home.presentation.fragment.orderdetails.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import br.com.andersonluisdev.common.baseviewmodel.viewmodel.BaseViewModel
import br.com.andersonluisdev.domain.model.orderdetails.OrderDetails
import br.com.andersonluisdev.domain.usecase.orderdetails.GetOrderDetailsUseCase
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.action.OrderDetailsAction
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.mapper.toOrderDetailsDataUiMapper
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.state.OrderDetailsViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class OrderDetailsViewModel(
    private val getOrderDetailsUseCase: GetOrderDetailsUseCase
) : BaseViewModel<OrderDetailsViewState, OrderDetailsAction>(OrderDetailsViewState()) {

    fun getOrderDetails(orderId: Int) {
        handleLoadingState()
        viewModelScope.launch {
            try {
                getOrderDetailsUseCase(orderId).collect(::handleGetOrderDetailsState)
            } catch (t: Throwable) {
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

    private fun handleGetOrderDetailsState(orderDetails: OrderDetails) {
        orderDetails.let { order ->
            if (order.success == false) {
                handleGenericErrorState()
            } else {
                setState { state ->
                    state.setSuccessState(order.toOrderDetailsDataUiMapper())
                }
            }
        }
    }

    private fun handleGenericErrorState() {
        setState { state ->
            state.setGenericErrorState()
        }
    }

    fun tryAgainClicked(orderId: Int) {
        setState {
            initialState
        }
        getOrderDetails(orderId)
    }
}
