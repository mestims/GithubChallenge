package br.com.githubchallenge.di.module

import android.app.Application
import android.content.Context
import br.com.githubchallenge.App
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun provideContext(application: App): Context = application.applicationContext

    @Provides
    fun provideApplication(application: App): Application = application

}