package br.com.githubchallenge

import android.app.Activity
import android.app.Application
import br.com.githubchallenge.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .application(this)
            .baseUrl("https://api.github.com/")
            .build()
            .inject(this)


    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
}