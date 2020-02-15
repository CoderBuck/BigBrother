package me.buck.bigbrother

import android.content.Context
import android.content.Intent

object Starter {

    fun monitorService(context: Context) {
        context.startService(Intent(context,MonitorService::class.java))
    }
}