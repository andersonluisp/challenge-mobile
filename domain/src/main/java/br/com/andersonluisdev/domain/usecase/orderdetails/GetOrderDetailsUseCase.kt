package br.com.andersonluisdev.domain.usecase.orderdetails

import br.com.andersonluisdev.domain.repository.OrderDetailsRepository

class GetOrderDetailsUseCase(
    private val orderDetailsRepository: OrderDetailsRepository
) {
    suspend operator fun invoke(orderId: Int) = orderDetailsRepository.getOrderDetails(orderId)
}
