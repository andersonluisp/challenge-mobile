package br.com.andersonluisdev.login.presentation.dataui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginDataUi(
    val avatarUrl: String?,
    val city: String?,
    val email: String?,
    val fullName: String?,
    val stateAbbr: String?,
    val success: Boolean?,
    val token: String?,
    val username: String?,
    val errorMessage: String?
): Parcelable
