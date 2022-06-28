package br.com.andersonluisdev.domain.model.login

data class Login(
    val avatarUrl: String?,
    val city: String?,
    val email: String?,
    val fullName: String?,
    val stateAbbr: String?,
    val success: Boolean?,
    val token: String?,
    val username: String?,
    val errorMessage: String?
)
