package br.com.githubchallenge

import br.com.githubchallenge.feature.main.MainRepository
import br.com.githubchallenge.feature.main.paging.GithubDataSource
import br.com.githubchallenge.feature.main.paging.MainThreadExecutor
import br.com.githubchallenge.feature.main.service.GithubApi
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import org.junit.Test

class MainRepositoryTest {

    private val service: GithubApi = mockk(relaxed = true)
    private val executor: MainThreadExecutor = mockk(relaxed = true)
    private val dataSource = GithubDataSource(service)

    @Test
    fun `checking PagedList configs`() {
        val repository = MainRepository(dataSource, executor)

        val result = repository.getRepos()

        assert(result.dataSource is GithubDataSource)
        assertEquals(result.config.pageSize, 20)
        assertEquals(result.config.initialLoadSizeHint, 40)
        assertEquals(result.config.enablePlaceholders, true)
    }
}