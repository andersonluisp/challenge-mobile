package br.com.andersonluisdev.data.model.profile

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    val city: String?,
    @SerializedName("fullname")
    val fullName: String?,
    val orders: List<OrderResponse>?,
    @SerializedName("state_abbr")
    val stateAbbr: String?,
    val success: Boolean?,
    val username: String?
)
