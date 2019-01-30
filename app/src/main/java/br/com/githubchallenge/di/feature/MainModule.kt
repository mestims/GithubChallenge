package br.com.githubchallenge.di.feature

import android.arch.lifecycle.ViewModelProviders
import br.com.githubchallenge.feature.main.MainActivity
import br.com.githubchallenge.di.ViewModelFactory
import br.com.githubchallenge.feature.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun providesMainViewModel(activity: MainActivity, factory: ViewModelFactory): MainViewModel {
        return ViewModelProviders.of(activity, factory)[MainViewModel::class.java]
    }


}
