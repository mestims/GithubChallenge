package br.com.githubchallenge.main

import androidx.paging.PagedListAdapter
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.GeneralLocation
import androidx.test.espresso.action.GeneralSwipeAction
import androidx.test.espresso.action.Press
import androidx.test.espresso.action.Swipe
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import br.com.githubchallenge.R
import br.com.githubchallenge.crazymock.MockServer
import br.com.githubchallenge.feature.main.MainActivity
import br.com.githubchallenge.feature.main.RepositoryViewHolder
import br.com.githubchallenge.feature.main.service.model.Item
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.mockwebserver.MockResponse
import java.nio.charset.Charset

class MainActivityRobot(val rule: ActivityTestRule<MainActivity>) {


    private val server = MockServer.mockWebServer
    fun prepareServer() {
        val context = InstrumentationRegistry.getInstrumentation().context

        val page1 =
            context.resources.assets.open("page1.json").bufferedReader(Charset.defaultCharset()).use { it.readText() }
        val page2 =
            context.resources.assets.open("page2.json").bufferedReader(Charset.defaultCharset()).use { it.readText() }
        val page3 =
            context.resources.assets.open("page3.json").bufferedReader(Charset.defaultCharset()).use { it.readText() }



        server.enqueue(MockResponse().setBody(page1).setResponseCode(200))
        server.enqueue(MockResponse().setBody(page2).setResponseCode(200))
        server.enqueue(MockResponse().setBody(page3).setResponseCode(200))
    }

    fun scrollToEnd() {
        Thread.sleep(1500)
        val itemcount = rule.activity.repository_list.adapter?.itemCount
        onView(withId(R.id.repository_list)).perform(
            RecyclerViewActions.scrollToPosition<RepositoryViewHolder>(itemcount!! - 1)
        )
    }

    fun refresh() {
        Thread.sleep(1500)
        onView(withId(R.id.repository_list)).perform(
            GeneralSwipeAction(
                Swipe.FAST, GeneralLocation.TOP_CENTER,
                GeneralLocation.BOTTOM_CENTER, Press.FINGER
            )
        )
    }

    fun checkIfRecyclerViewHasCorrectNumberOfItens() {
        Thread.sleep(1500)
        val itemcount = rule.activity.repository_list.adapter?.itemCount
        assertEquals(41, itemcount)
    }

    fun checkIfLoadedMore() {
        Thread.sleep(1500)
        val itemcount = rule.activity.repository_list.adapter?.itemCount
        assertTrue(itemcount!! > 41)
    }

    fun checkIfRefreshedList() {
        val item = (rule.activity.repository_list.adapter as PagedListAdapter<*,*>).currentList?.get(0) as Item
        assertTrue(item.name == "kotlin41")

    }

}

fun mainRobot(rule: ActivityTestRule<MainActivity>, func: MainActivityRobot.() -> Unit) = MainActivityRobot(rule)
    .apply { func() }