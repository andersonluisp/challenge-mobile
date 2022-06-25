package br.com.andersonluisdev.login.presentation.mapper

import br.com.andersonluisdev.domain.model.login.Login
import br.com.andersonluisdev.login.presentation.dataui.LoginDataUi

fun Login.toLoginDataUiMapper() = LoginDataUi(
    avatarUrl = avatarUrl,
    city = city,
    email = email,
    fullName = fullName,
    stateAbbr = stateAbbr,
    success = success,
    token = token,
    username = username,
    errorMessage = errorMessage
)
