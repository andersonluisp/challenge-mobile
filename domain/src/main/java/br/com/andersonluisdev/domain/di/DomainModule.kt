package br.com.andersonluisdev.domain.di

import br.com.andersonluisdev.domain.usecase.login.SignInUseCase
import br.com.andersonluisdev.domain.usecase.orderdetails.GetOrderDetailsUseCase
import br.com.andersonluisdev.domain.usecase.userprofile.GetUserProfileUseCase
import br.com.andersonluisdev.domain.usecase.usersubscriptions.GetUserSubscriptionsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { SignInUseCase(loginRepository = get()) }

    factory { GetUserProfileUseCase( userProfileRepository = get()) }

    factory { GetUserSubscriptionsUseCase(userSubscriptionsRepository = get()) }

    factory { GetOrderDetailsUseCase(orderDetailsRepository = get()) }
}
