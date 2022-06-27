package br.com.andersonluisdev.data.remote.mappers.userprofile

import br.com.andersonluisdev.data.remote.model.ErrorResponse
import br.com.andersonluisdev.data.remote.model.profile.UserProfileResponse
import br.com.andersonluisdev.domain.model.profile.UserProfile

fun UserProfileResponse.toUserProfileMapper() = UserProfile(
    avatarUrl = avatarUrl,
    city = city,
    fullName = fullName,
    orders = orders?.map { it.toOrderMapper() },
    stateAbbr = stateAbbr,
    success = success,
    username = username,
    errorMessage = errorMessage
)

fun ErrorResponse.toUserProfileMapper() = UserProfile(
    avatarUrl = null,
    city = null,
    fullName = null,
    orders = null,
    stateAbbr = null,
    success = success,
    username = null,
    errorMessage = errorMessage
)
