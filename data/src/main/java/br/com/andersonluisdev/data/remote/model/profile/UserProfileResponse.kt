package br.com.andersonluisdev.data.remote.model.profile

import com.google.gson.annotations.SerializedName

data class UserProfileResponse(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    val city: String?,
    @SerializedName("fullname")
    val fullName: String?,
    val orders: List<OrderResponse>?,
    @SerializedName("state_abbr")
    val stateAbbr: String?,
    val success: Boolean?,
    val username: String?,
    @SerializedName("error_message")
    val errorMessage: String?
)
