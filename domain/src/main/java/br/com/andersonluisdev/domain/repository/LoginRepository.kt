package br.com.andersonluisdev.domain.repository

import br.com.andersonluisdev.domain.model.login.Login
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    suspend fun signIn(email: String, password: String) : Flow<Login>
}
