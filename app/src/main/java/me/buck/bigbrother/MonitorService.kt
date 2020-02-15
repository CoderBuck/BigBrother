package me.buck.bigbrother

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MonitorService : Service() {

    lateinit var appReceiver: AppReceiver

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        appReceiver = AppReceiver(this)
        appReceiver.register()
    }

    override fun onDestroy() {
        super.onDestroy()
        appReceiver.unregister()
    }



}