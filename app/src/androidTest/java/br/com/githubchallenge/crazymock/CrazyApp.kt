package br.com.githubchallenge.crazymock

import android.util.Log
import br.com.githubchallenge.App
import br.com.githubchallenge.di.component.DaggerAppComponent

class CrazyApp : App() {


    override fun onCreate() {
        super.onCreate()

        val server = MockServer.mockWebServer
        server.start()
        Log.d("tag", "mockando pesado ${server.url("/")}")
        DaggerAppComponent
            .builder()
            .application(this)
            .baseUrl(server.url("/").toString())
            .build()
            .inject(this)
    }
}