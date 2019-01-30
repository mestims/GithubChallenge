package br.com.githubchallenge.di.feature

import br.com.githubchallenge.feature.main.MainRepository
import br.com.githubchallenge.paging.GithubDataSource
import br.com.githubchallenge.paging.MainThreadExecutor
import br.com.githubchallenge.service.GithubApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
open class MainRepositoryModule {

    @Provides
    open fun providesMainRepository(dataSource: GithubDataSource, executor: MainThreadExecutor) =
        MainRepository(dataSource, executor)

    @Provides
    fun providesApiService(retrofit: Retrofit): GithubApi = retrofit.create(GithubApi::class.java)

}