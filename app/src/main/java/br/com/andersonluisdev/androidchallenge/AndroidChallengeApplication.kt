package br.com.andersonluisdev.androidchallenge

import android.app.Application
import br.com.andersonluisdev.data.remote.di.dataModule
import br.com.andersonluisdev.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AndroidChallengeApplication: Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AndroidChallengeApplication)
            modules(dataModule, domainModule)
        }
    }
}
