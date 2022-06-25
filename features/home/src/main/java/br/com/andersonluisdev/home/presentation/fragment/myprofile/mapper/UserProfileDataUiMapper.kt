package br.com.andersonluisdev.home.presentation.fragment.myprofile.mapper

import br.com.andersonluisdev.domain.model.profile.UserProfile
import br.com.andersonluisdev.home.presentation.fragment.myprofile.dataui.UserProfileDataUi

fun UserProfile.toUserProfileDataUiMapper() = UserProfileDataUi(
    avatarUrl = avatarUrl,
    city = city,
    fullName = fullName,
    orders = orders?.map { it.toOrderDataUiMapperMapper() },
    stateAbbr = stateAbbr,
    success = success,
    username = username,
    errorMessage = errorMessage
)
