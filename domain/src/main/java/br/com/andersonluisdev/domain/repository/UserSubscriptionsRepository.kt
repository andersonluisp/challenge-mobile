package br.com.andersonluisdev.domain.repository

import br.com.andersonluisdev.domain.model.profile.Order
import kotlinx.coroutines.flow.Flow

interface UserSubscriptionsRepository {
    suspend fun getUserSubscriptions() : Flow<List<Order>?>
}
