package br.com.githubchallenge.feature.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.githubchallenge.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    private val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        getList()
    }

    private fun setupViews() {
        repository_list.apply {
            adapter = this@MainActivity.adapter
            layoutManager = LinearLayoutManager(context)
        }

        swipe_container.setOnRefreshListener {
            getList()
        }
    }

    private fun getList() {
        viewModel.getRepositoriesList()?.observe(this, Observer {
            swipe_container.isRefreshing = false
            adapter.submitList(it)
        })
    }

}
