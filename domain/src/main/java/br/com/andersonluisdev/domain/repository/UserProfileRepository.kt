package br.com.andersonluisdev.domain.repository

import br.com.andersonluisdev.domain.model.profile.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {

    suspend fun getUserProfile() : Flow<UserProfile?>
}
