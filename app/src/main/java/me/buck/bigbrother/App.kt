package me.buck.bigbrother

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        ObjectBox.init(this)
        Timber.plant(Timber.DebugTree())
    }

}