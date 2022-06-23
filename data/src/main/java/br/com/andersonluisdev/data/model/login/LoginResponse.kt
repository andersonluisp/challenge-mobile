package br.com.andersonluisdev.data.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    val city: String?,
    val email: String?,
    @SerializedName("fullname")
    val fullName: String?,
    @SerializedName("state_abbr")
    val stateAbbr: String?,
    val success: Boolean?,
    val token: String?,
    val username: String?,
    @SerializedName("error_message")
    val errorMessage: String?
)
