package br.com.andersonluisdev.domain.di

import br.com.andersonluisdev.domain.usecase.login.SignInUseCase
import br.com.andersonluisdev.domain.usecase.userprofile.GetUserProfileUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { SignInUseCase(loginRepository = get()) }

    factory { GetUserProfileUseCase( userProfileRepository = get()) }
}
