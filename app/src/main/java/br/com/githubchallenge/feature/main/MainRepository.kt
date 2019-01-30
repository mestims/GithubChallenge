package br.com.githubchallenge.feature.main

import android.arch.paging.PagedList
import br.com.githubchallenge.paging.GithubDataSource
import br.com.githubchallenge.paging.MainThreadExecutor
import br.com.githubchallenge.service.model.Item
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val dataSource: GithubDataSource,
    private val executor: MainThreadExecutor
) {

    fun getRepos(): PagedList<Item> {
        val config = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(40)
            .setEnablePlaceholders(true)
            .build()

        val list = PagedList.Builder(dataSource, config)
            .setFetchExecutor(executor)
            .setNotifyExecutor(executor)
            .build()

        return list
    }

}