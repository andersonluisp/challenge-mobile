package br.com.andersonluisdev.home.presentation.di

import br.com.andersonluisdev.home.presentation.fragment.userprofile.viewmodel.UserProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homePresentationModule = module {
    viewModel { UserProfileViewModel(getUserProfileUseCase = get()) }
}
