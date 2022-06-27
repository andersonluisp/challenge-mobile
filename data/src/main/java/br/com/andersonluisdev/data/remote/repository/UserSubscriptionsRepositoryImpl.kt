package br.com.andersonluisdev.data.remote.repository

import br.com.andersonluisdev.data.remote.api.ApiData
import br.com.andersonluisdev.data.remote.api.ApiService
import br.com.andersonluisdev.data.remote.mappers.toErrorResponseMapper
import br.com.andersonluisdev.data.remote.mappers.userprofile.toOrderMapper
import br.com.andersonluisdev.domain.model.profile.Order
import br.com.andersonluisdev.domain.repository.UserSubscriptionsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class UserSubscriptionsRepositoryImpl(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UserSubscriptionsRepository {
    override suspend fun getUserSubscriptions(): Flow<List<Order?>?> =
        withContext(dispatcher) {
            flow {
                apiService.getUserOrders(ApiData.token).apply {
                    if (this.isSuccessful) {
                        val listOrders = this.body()?.map {
                            it.toOrderMapper()
                        }
                        emit(listOrders)
                    } else {
                        val listErrorResponse =
                            listOf(errorBody()?.toErrorResponseMapper()?.toOrderMapper())
                        emit(listErrorResponse)
                    }
                }
            }
        }
}
