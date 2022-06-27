package br.com.andersonluisdev.domain.repository

import br.com.andersonluisdev.domain.model.orderdetails.OrderDetails
import kotlinx.coroutines.flow.Flow

interface OrderDetailsRepository {
    suspend fun getOrderDetails(orderId: Int) : Flow<OrderDetails>
}
