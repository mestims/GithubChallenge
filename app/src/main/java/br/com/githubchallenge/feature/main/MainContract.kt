package br.com.githubchallenge.feature.main

import androidx.paging.PagedList
import br.com.githubchallenge.service.model.Item

interface MainContract {

    interface View {
        fun showList(pagedList: PagedList<Item>)

        fun hideLoading()
    }

    interface Presenter {
        fun getList()
    }
}