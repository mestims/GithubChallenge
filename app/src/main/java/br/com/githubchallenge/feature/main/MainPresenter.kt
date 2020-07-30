package br.com.githubchallenge.feature.main

class MainPresenter(
    private val view: MainContract.View,
    private val repository: MainRepository
) : MainContract.Presenter {

    override fun getList() {
        view.showList(repository.getRepos())
        view.hideLoading()
    }
}