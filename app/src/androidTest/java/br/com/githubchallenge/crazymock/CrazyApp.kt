package br.com.githubchallenge.crazymock

import android.util.Log
import br.com.githubchallenge.App
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class CrazyApp : App() {

    private val server = MockServer.mockWebServer

    override fun onCreate() {
        super.onCreate()

        server.start()
        Log.d("tag", "mockando pesado ${server.url("/")}")

    }

    override fun setup() {
        loadKoinModules(
            module {
                factory<String>(override = true) { server.url("/").toString() }
            }
        )
    }
}