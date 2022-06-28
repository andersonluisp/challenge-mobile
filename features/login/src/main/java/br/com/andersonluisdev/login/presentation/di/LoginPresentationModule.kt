package br.com.andersonluisdev.login.presentation.di

import br.com.andersonluisdev.login.presentation.activity.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginPresentationModule = module {

    viewModel {
        LoginViewModel(
            signInUseCase = get()
        )
    }
}
