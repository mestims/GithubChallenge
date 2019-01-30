package br.com.githubchallenge.di.feature

import br.com.githubchallenge.paging.GithubDataSource
import br.com.githubchallenge.paging.MainThreadExecutor
import br.com.githubchallenge.service.GithubApi
import dagger.Module
import dagger.Provides

@Module
class DataSourceModule {

    @Provides
    fun provideGithubDataSource(service: GithubApi): GithubDataSource = GithubDataSource(service)


    @Provides
    fun providesExecutor(): MainThreadExecutor = MainThreadExecutor()
}