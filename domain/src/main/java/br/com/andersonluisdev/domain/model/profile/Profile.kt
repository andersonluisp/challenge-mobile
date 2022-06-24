package br.com.andersonluisdev.domain.model.profile

data class Profile(
    val avatarUrl: String?,
    val city: String?,
    val fullName: String?,
    val orders: List<Order>?,
    val stateAbbr: String?,
    val success: Boolean?,
    val username: String?
)
