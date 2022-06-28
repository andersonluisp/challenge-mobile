package br.com.andersonluisdev.domain.usecase.userprofile

import br.com.andersonluisdev.domain.model.profile.UserProfile
import br.com.andersonluisdev.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow

class GetUserProfileUseCase(
    private val userProfileRepository: UserProfileRepository
) {

    suspend operator fun invoke(): Flow<UserProfile?> =
        userProfileRepository.getUserProfile()
}
