package br.com.githubchallenge.crazymock

import okhttp3.mockwebserver.MockWebServer

object MockServer {

    val mockWebServer: MockWebServer by lazy {
        MockWebServer()
    }
}