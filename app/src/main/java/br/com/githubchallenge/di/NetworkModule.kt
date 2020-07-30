package br.com.githubchallenge.di

import android.app.Application
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val BASE_URL = "https://api.github.com/"

    val instance = module {

        factory<Cache> { providesOkHttpCache(get()) }

        factory<OkHttpClient> { providesOkHttpClient(get()) }

        factory<Retrofit> { provideRetrofit(get(), get()) }

        factory<String> { BASE_URL }
    }

    private fun providesOkHttpCache(application: Application): Cache {
        val cacheSize = 10L * 1024L * 1024L
        val cache = Cache(application.cacheDir, cacheSize)
        return cache
    }

    private fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    private fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}