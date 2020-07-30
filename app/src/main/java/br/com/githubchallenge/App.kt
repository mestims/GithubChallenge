package br.com.githubchallenge

import android.app.Application
import br.com.githubchallenge.di.NetworkModule
import br.com.githubchallenge.feature.main.MainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(NetworkModule.instance, MainModule.instance))
        }
        setup()
    }

    open fun setup() {}
}