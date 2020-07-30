package br.com.githubchallenge.feature.main.paging

import androidx.paging.PageKeyedDataSource
import br.com.githubchallenge.feature.main.service.GithubApi
import br.com.githubchallenge.feature.main.service.model.GitRepositories
import br.com.githubchallenge.feature.main.service.model.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubDataSource constructor(
    private val service: GithubApi
) : PageKeyedDataSource<Int, Item>() {

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Item>) {
        githubCall().enqueue(object : Callback<GitRepositories> {
            override fun onFailure(call: Call<GitRepositories>, t: Throwable) {
                print("deu ruim")
            }

            override fun onResponse(call: Call<GitRepositories>, response: Response<GitRepositories>) {
                response.body()?.let {
                    callback.onResult(
                        it.items,
                        0,
                        it.items.size,
                        null,
                        2
                    )
                }
            }

        })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val page = params.key

        githubCall(page).enqueue(object : Callback<GitRepositories> {
            override fun onFailure(call: Call<GitRepositories>, t: Throwable) {
                print("deu ruim")
            }

            override fun onResponse(call: Call<GitRepositories>, response: Response<GitRepositories>) {
                response.body()?.let {
                    callback.onResult(
                        it.items,
                        page + 1
                    )
                }
            }
        })

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
    }

    private fun githubCall(page: Int = 1): Call<GitRepositories> {
        return service.searchRepos(
            "kotlin:language",
            "forks",
            page,
            20
        )
    }

}