package br.com.githubchallenge.main

import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import br.com.githubchallenge.feature.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun whenActivityStartsItShouldHaveSomeListLoaded() {
        mainRobot(activityRule) {
            prepareServer()
            checkIfRecyclerViewHasCorrectNumberOfItens()
        }
    }

    @Test
    fun whenIScrollToTheEndOfListItShouldLoadMore() {
        mainRobot(activityRule) {
            prepareServer()
            scrollToEnd()
            checkIfLoadedMore()
        }
    }

    @Test
    fun whenISwipeToRefreshItShouldRefreshTheCurrentList() {
        mainRobot(activityRule) {
            prepareServer()
            refresh()
            checkIfRefreshedList()
        }
    }
}