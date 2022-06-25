package br.com.andersonluisdev.data.remote.repository

import br.com.andersonluisdev.data.remote.api.ApiData
import br.com.andersonluisdev.data.remote.api.ApiService
import br.com.andersonluisdev.data.remote.mappers.toErrorResponseMapper
import br.com.andersonluisdev.data.remote.mappers.userprofile.toUserProfileMapper
import br.com.andersonluisdev.domain.model.profile.UserProfile
import br.com.andersonluisdev.domain.repository.UserProfileRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class UserProfileRepositoryImpl(
    private val apiService: ApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : UserProfileRepository {

    override suspend fun getUserProfile(): Flow<UserProfile?> =
        withContext(dispatcher) {
            flow {
                apiService.getUserProfile(ApiData.token).apply {
                    if (this.isSuccessful) {
                        emit(this.body()?.toUserProfileMapper())
                    } else {
                        emit(errorBody()?.toErrorResponseMapper()?.toUserProfileMapper())
                    }
                }
            }
        }
}
