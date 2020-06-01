package me.buck.bigbrother

import android.accessibilityservice.AccessibilityService
import android.app.Service
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import timber.log.Timber

/**
 * @see https://informationaccessibilityassociation.github.io/androidAccessibility/services.htm
 */
class MyAccessibilityService : AccessibilityService() {

    override fun onCreate() {
        super.onCreate()
        logMethod("onCreate")
    }

//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        super.onStartCommand(intent, flags, startId)
//        return Service.START_STICKY
//    }

    override fun onInterrupt() {
        logMethod("onInterrupt")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        logMethod("onAccessibilityEvent")

    }

    override fun onServiceConnected() {
        super.onServiceConnected()

    }

    override fun onUnbind(intent: Intent?): Boolean {
        logMethod("onUnbind")
        return super.onUnbind(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        logMethod("onDestroy")
    }

    ///////////////////////
    private fun logMethod(methodName: String) {
        Timber.d("method : $methodName")
    }
}