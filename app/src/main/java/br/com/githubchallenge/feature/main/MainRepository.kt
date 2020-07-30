package br.com.githubchallenge.feature.main

import androidx.paging.PagedList
import br.com.githubchallenge.feature.main.paging.GithubDataSource
import br.com.githubchallenge.feature.main.paging.MainThreadExecutor
import br.com.githubchallenge.feature.main.service.model.Item

class MainRepository constructor(
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