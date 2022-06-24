package br.com.andersonluisdev.domain.di

import br.com.andersonluisdev.domain.usecase.login.SignInUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { SignInUseCase(loginRepository = get()) }
}
