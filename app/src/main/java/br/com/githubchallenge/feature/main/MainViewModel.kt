package br.com.githubchallenge.feature.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import br.com.githubchallenge.service.model.Item
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    var pagedListLiveData: MutableLiveData<PagedList<Item>>? = MutableLiveData()

    fun getRepositoriesList(): LiveData<PagedList<Item>>? {
        pagedListLiveData?.postValue(repository.getRepos())
        return pagedListLiveData
    }
}