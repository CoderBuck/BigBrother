package me.buck.bigbrother

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Actions.BOOT_COMPLETED -> {
                Starter.monitorService(context!!)
            }
        }
    }

}