package br.com.githubchallenge

import android.content.ClipData
import br.com.githubchallenge.feature.main.MainContract
import br.com.githubchallenge.feature.main.MainPresenter
import br.com.githubchallenge.feature.main.MainRepository
import io.mockk.Ordering
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class MainPresenterTest {

    private val view = mockk<MainContract.View>(relaxed = true)
    private val repository = mockk<MainRepository>(relaxed = true)

    @Test
    fun `when getList is called, it should showList and then hideLoading`() {
        val presenter = MainPresenter(view, repository)

        presenter.getList()

        verify(ordering = Ordering.SEQUENCE) {
            view.showList(any())
            view.hideLoading()
        }
    }
}