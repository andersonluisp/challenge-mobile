package br.com.andersonluisdev.home.presentation.fragment.myprofile.dataui

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
