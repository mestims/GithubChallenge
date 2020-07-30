package br.com.githubchallenge.feature.main.service

import br.com.githubchallenge.feature.main.service.model.GitRepositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("/search/repositories")
    fun searchRepos(
        @Query("q") q: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): Call<GitRepositories>

}