package br.com.andersonluisdev.data.remote.di

import br.com.andersonluisdev.data.remote.api.ApiService
import br.com.andersonluisdev.data.remote.repository.LoginRepositoryImpl
import br.com.andersonluisdev.domain.repository.LoginRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


private const val TIMEOUT_CONNECTION = 30L

val dataModule = module {

    factory { providesOkHttpClient() }

    single {
        createWebService<ApiService>(
            okHttpClient = get(),
        )
    }

    factory<LoginRepository> { LoginRepositoryImpl(
        apiService = get()
    ) }

}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient): T {
    val baseUrl = "https://challenge-mobile-api.modl.pro/api/v1/"
    return Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
        .create(T::class.java)
}

fun providesOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
        .readTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_CONNECTION, TimeUnit.SECONDS)
        .build()
}
