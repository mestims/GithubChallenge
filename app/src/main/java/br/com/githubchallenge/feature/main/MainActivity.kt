package br.com.githubchallenge.feature.main

import androidx.paging.PagedList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.githubchallenge.R
import br.com.githubchallenge.feature.main.service.model.Item
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), MainContract.View {

    private val adapter = MainAdapter()
    private val presenter: MainContract.Presenter by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        presenter.getList()
    }

    private fun setupViews() {
        repository_list.apply {
            adapter = this@MainActivity.adapter
            layoutManager =
                androidx.recyclerview.widget.LinearLayoutManager(context)
        }
        swipe_container.setOnRefreshListener { presenter.getList() }
    }

    override fun showList(pagedList: PagedList<Item>) {
        adapter.submitList(pagedList)
    }

    override fun hideLoading() {
        swipe_container.isRefreshing = false
    }
}
