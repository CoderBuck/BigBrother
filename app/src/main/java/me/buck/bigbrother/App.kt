package me.buck.bigbrother

import android.app.Application
import com.blankj.utilcode.util.CrashUtils
import com.blankj.utilcode.util.Utils
import com.jakewharton.threetenabp.AndroidThreeTen
import timber.log.Timber

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        ObjectBox.init(this)
        Timber.plant(object : Timber.DebugTree() {
            override fun createStackElementTag(element: StackTraceElement): String? {
                return "kd-" + super.createStackElementTag(element)
            }
        })
        Utils.init(this)
        CrashUtils.init(filesDir.absolutePath + "/crash/")
    }

}