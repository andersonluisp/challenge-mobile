package br.com.andersonluisdev.domain.model.profile

data class UserProfile(
    val avatarUrl: String?,
    val city: String?,
    val fullName: String?,
    val orders: List<Order>?,
    val stateAbbr: String?,
    val success: Boolean?,
    val username: String?,
    val errorMessage: String?
)
