package br.com.andersonluisdev.data.remote.mappers.login

import br.com.andersonluisdev.data.remote.model.ErrorResponse
import br.com.andersonluisdev.data.remote.model.login.LoginResponse
import br.com.andersonluisdev.domain.model.login.Login

fun LoginResponse.toLoginMapper() =
    Login(
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

fun ErrorResponse.toLoginMapper() =
    Login(
        avatarUrl = null,
        city = null,
        email = null,
        fullName = null,
        stateAbbr = null,
        success = success,
        token = null,
        username = null,
        errorMessage = errorMessage
    )
