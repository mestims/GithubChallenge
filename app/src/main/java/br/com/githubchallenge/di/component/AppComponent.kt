package br.com.githubchallenge.di.component

import br.com.githubchallenge.App
import br.com.githubchallenge.di.feature.DataSourceModule
import br.com.githubchallenge.di.feature.MainRepositoryModule
import br.com.githubchallenge.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        BuildersModule::class,
        ApplicationModule::class,
        RestModule::class,
        MainRepositoryModule::class,
        DataSourceModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        @BindsInstance
        fun baseUrl(baseUrl: String): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}