package br.com.githubchallenge.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.githubchallenge.di.ViewModelFactory
import br.com.githubchallenge.di.ViewModelKey
import br.com.githubchallenge.di.feature.DataSourceModule
import br.com.githubchallenge.di.feature.MainModule
import br.com.githubchallenge.feature.main.MainActivity
import br.com.githubchallenge.feature.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainActivity(): MainActivity

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}