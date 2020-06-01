package me.buck.bigbrother.app

import android.app.Application
import com.blankj.utilcode.util.CrashUtils
import com.blankj.utilcode.util.Utils
import com.jakewharton.threetenabp.AndroidThreeTen
import me.buck.bigbrother.ObjectBox
import me.buck.bigbrother.Starter
import me.buck.bigbrother.tool.KdDebugTree
import timber.log.Timber

@Suppress("unused")
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        ObjectBox.init(this)
        Timber.plant(KdDebugTree())
        Utils.init(this)
        CrashUtils.init(filesDir.absolutePath + "/crash/")
        Starter.monitorService(this)
    }

}