package br.com.andersonluisdev.home.presentation.fragment.userprofile.dataui

data class UserProfileDataUi(
    val avatarUrl: String?,
    val city: String?,
    val fullName: String?,
    val orders: List<OrderDataUi>?,
    val stateAbbr: String?,
    val success: Boolean?,
    val username: String?,
    val errorMessage: String?
)
