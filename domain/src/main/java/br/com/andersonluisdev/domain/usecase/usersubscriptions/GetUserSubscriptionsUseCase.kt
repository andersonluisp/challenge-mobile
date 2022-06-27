package br.com.andersonluisdev.domain.usecase.usersubscriptions

import br.com.andersonluisdev.domain.model.profile.Order
import br.com.andersonluisdev.domain.repository.UserSubscriptionsRepository
import kotlinx.coroutines.flow.Flow

class GetUserSubscriptionsUseCase(
    private val userSubscriptionsRepository: UserSubscriptionsRepository
) {
    suspend operator fun invoke(): Flow<List<Order>?> =
        userSubscriptionsRepository.getUserSubscriptions()
}
