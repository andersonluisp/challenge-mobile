package br.com.andersonluisdev.data.remote.repository

import br.com.andersonluisdev.data.remote.api.ApiClient
import br.com.andersonluisdev.data.remote.api.ApiService
import br.com.andersonluisdev.data.remote.mappers.login.toLoginMapper
import br.com.andersonluisdev.data.remote.mappers.toErrorResponseMapper
import br.com.andersonluisdev.domain.model.login.Login
import br.com.andersonluisdev.domain.repository.LoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class LoginRepositoryImpl(
    private val apiService: ApiService = ApiClient.retrofitInstance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : LoginRepository {

    override suspend fun signIn(email: String, password: String): Flow<Login?> =
        withContext(dispatcher) {
            flow {
                apiService.signIn(email, password).apply {
                    if (this.isSuccessful) {
                        emit(this.body()?.toLoginMapper())
                    } else {
                        emit(errorBody()?.toErrorResponseMapper()?.toLoginMapper())
                    }
                }
            }
        }
}
