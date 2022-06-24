package br.com.andersonluisdev.domain.usecase.login

import br.com.andersonluisdev.domain.model.login.Login
import br.com.andersonluisdev.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class SignInUseCase(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(email: String, password: String): Flow<Login> =
        loginRepository.signIn(email, password)
}
