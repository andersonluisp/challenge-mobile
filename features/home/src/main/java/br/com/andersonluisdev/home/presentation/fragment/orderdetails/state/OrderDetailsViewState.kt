package br.com.andersonluisdev.home.presentation.fragment.orderdetails.state

import br.com.andersonluisdev.common.baseviewmodel.state.ViewState
import br.com.andersonluisdev.home.presentation.fragment.orderdetails.dataui.OrderDetailsDataUi

data class OrderDetailsViewState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val orderDetails: OrderDetailsDataUi? = null,
    val isError: Boolean = false
) : ViewState {
    fun setLoadingState() = this.copy(
        isLoading = true,
        isSuccess = false,
        orderDetails = null,
        isError = false
    )

    fun setSuccessState(newOrderDetails: OrderDetailsDataUi) = this.copy(
        isLoading = false,
        isSuccess = true,
        orderDetails = newOrderDetails,
        isError = false
    )

    fun setGenericErrorState() = this.copy(
        isLoading = false,
        isSuccess = false,
        orderDetails = null,
        isError = true
    )
}
