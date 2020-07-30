package br.com.githubchallenge.feature.main

import br.com.githubchallenge.paging.GithubDataSource
import br.com.githubchallenge.paging.MainThreadExecutor
import br.com.githubchallenge.service.GithubApi
import org.koin.dsl.module
import retrofit2.Retrofit

object MainModule {

    val instance = module {

        factory<MainContract.Presenter> { (view: MainContract.View) -> MainPresenter(view, get()) }

        factory<MainRepository> { MainRepository(get(), get()) }

        factory<GithubDataSource> { GithubDataSource(get()) }

        factory<MainThreadExecutor> { MainThreadExecutor() }

        factory<GithubApi> { get<Retrofit>().create(GithubApi::class.java) }

    }
}