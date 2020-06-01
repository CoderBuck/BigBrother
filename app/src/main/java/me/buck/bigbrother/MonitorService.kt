package me.buck.bigbrother

import android.app.Service
import android.content.Intent
import android.os.IBinder
import me.buck.receiver.AutoReceiver

class MonitorService : Service() {

    private val appReceiver = AppReceiver()

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        AutoReceiver.bind(this, appReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        AutoReceiver.unbind(appReceiver)
    }


}