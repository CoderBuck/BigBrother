package me.buck.bigbrother.receiver

import android.content.Intent
import me.buck.bigbrother.EmLock
import me.buck.bigbrother.ObjectBox
import me.buck.bigbrother.ScreenLockInfo
import me.buck.receiver.annotation.GlobalAction
import org.threeten.bp.LocalDateTime
import timber.log.Timber

class AppReceiver {

    @GlobalAction(Intent.ACTION_SCREEN_OFF)
    fun onScreenOff(intent: Intent) {
        Timber.d("onScreenOff")
        val info = ScreenLockInfo(0, LocalDateTime.now().toString(), EmLock.lock)
        val box = ObjectBox.screenLockInfoBox()
        box.put(info)
    }

    @GlobalAction(Intent.ACTION_SCREEN_ON)
    fun onScreenOn(intent: Intent) {
        Timber.d("onScreenOn")

    }

    @GlobalAction(Intent.ACTION_USER_PRESENT)
    fun onUserPresent(intent: Intent) {
        Timber.d("onUserPresent")
        val info = ScreenLockInfo(0, LocalDateTime.now().toString(), EmLock.unlock)
        val box = ObjectBox.screenLockInfoBox()
        box.put(info)
    }

}