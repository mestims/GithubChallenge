package br.com.githubchallenge.di.module

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RestModule {

    @Provides
    @Singleton
    fun providesOkHttpCache(application: Application): Cache {
        val cacheSize = 10L * 1024L * 1024L
        val cache = Cache(application.cacheDir, cacheSize)
        return cache
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(cache: Cache): OkHttpClient {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl:String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
    }
}
