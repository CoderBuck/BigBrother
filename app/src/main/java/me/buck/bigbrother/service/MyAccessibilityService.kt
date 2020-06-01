package me.buck.bigbrother.service

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import me.buck.bigbrother.app.AppModel
import me.buck.bigbrother.ui.PopManager
import timber.log.Timber

/**
 * @see https://informationaccessibilityassociation.github.io/androidAccessibility/services.htm
 */
class MyAccessibilityService : AccessibilityService() {

    override fun onCreate() {
        super.onCreate()
        logMethod("onCreate")
    }

    override fun onInterrupt() {
        logMethod("onInterrupt")
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Timber.d("onAccessibilityEvent event = %s", event.toString())
        Timber.d("onAccessibilityEvent event source = %s", event?.source?.toString())
        if (event == null) return

        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val pkg = event.packageName ?: ""
            val clazz = event.className ?: ""


            Timber.d("onAccessibilityEvent pkg = %s, clazz = %s", pkg, clazz)

            if (PopManager.isTopActivityPopShowing()) {
                PopManager.topActivityPop!!.view.setPkg(pkg.toString())
                PopManager.topActivityPop!!.view.setClazz(clazz.toString())
            }


        }

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