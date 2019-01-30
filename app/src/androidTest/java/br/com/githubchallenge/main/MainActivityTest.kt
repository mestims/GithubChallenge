package br.com.githubchallenge.main

import android.support.test.rule.ActivityTestRule
import br.com.githubchallenge.feature.main.MainActivity
import org.junit.Rule
import org.junit.Test

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
    fun whenIScrollToTheEndOfListItShoulLoadMore() {
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