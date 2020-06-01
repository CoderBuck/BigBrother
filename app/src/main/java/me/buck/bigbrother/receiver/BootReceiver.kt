package me.buck.bigbrother.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import me.buck.bigbrother.Actions
import me.buck.bigbrother.Starter

class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
            Actions.BOOT_COMPLETED -> {
                Starter.monitorService(context!!)
            }
        }
    }

}