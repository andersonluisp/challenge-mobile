package br.com.andersonluisdev.data.remote.repository

import br.com.andersonluisdev.data.remote.api.ApiData
import br.com.andersonluisdev.data.remote.api.ApiService
import br.com.andersonluisdev.data.remote.mappers.orderdetails.toOrderDetailsMapper
import br.com.andersonluisdev.data.remote.mappers.toErrorResponseMapper
import br.com.andersonluisdev.data.remote.mappers.userprofile.toUserProfileMapper
import br.com.andersonluisdev.domain.model.orderdetails.OrderDetails
import br.com.andersonluisdev.domain.repository.OrderDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class OrderDetailsRepositoryImpl(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : OrderDetailsRepository {
    override suspend fun getOrderDetails(orderId: Int): Flow<OrderDetails> =
        withContext(dispatcher) {
            flow {
                apiService.getOrderDetails(ApiData.token, orderId).apply {
                    if (this.isSuccessful) {
                        this.body()?.let { response ->
                            emit(response.toOrderDetailsMapper())
                        }
                    } else {
                        errorBody()?.let { response ->
                            emit(response.toErrorResponseMapper().toOrderDetailsMapper())
                        }
                    }
                }
            }
        }
}
