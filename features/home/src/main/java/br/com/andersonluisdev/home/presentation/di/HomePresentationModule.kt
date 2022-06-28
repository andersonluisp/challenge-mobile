package br.com.andersonluisdev.home.presentation.di

import br.com.andersonluisdev.home.presentation.fragment.orderdetails.viewmodel.OrderDetailsViewModel
import br.com.andersonluisdev.home.presentation.fragment.userprofile.viewmodel.UserProfileViewModel
import br.com.andersonluisdev.home.presentation.fragment.usersubscriptions.viewmodel.UserSubscriptionsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel { UserProfileViewModel(getUserProfileUseCase = get()) }

    viewModel { UserSubscriptionsViewModel(getUserSubscriptionsUseCase = get()) }

    viewModel { OrderDetailsViewModel(getOrderDetailsUseCase = get()) }
}
