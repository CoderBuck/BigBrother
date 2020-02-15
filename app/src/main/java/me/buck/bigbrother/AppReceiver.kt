package me.buck.bigbrother

import android.content.Context
import android.content.Intent
import org.threeten.bp.LocalDateTime
import timber.log.Timber

class AppReceiver : SimpleReceiver {

    constructor(context: Context)
            : super(context, false) {
        mFilter.addAction(Actions.SCREEN_OFF)
        mFilter.addAction(Actions.USER_PRESENT)
    }


    override fun onReceive(context: Context?, intent: Intent?) {
        Timber.d(intent?.action)

        when (intent?.action) {
            Actions.SCREEN_OFF -> {
                val info = ScreenLockInfo(0, LocalDateTime.now().toString(), EmLock.lock)
                val box = ObjectBox.screenLockInfoBox()
                val list = box.query().build().find()
                val last = list.last()
                if (last.emLock == EmLock.unlock) {
                    box.put(info)
                }
            }

            Actions.USER_PRESENT -> {
                val info = ScreenLockInfo(0, LocalDateTime.now().toString(), EmLock.unlock)
                val box = ObjectBox.screenLockInfoBox()
                val list = box.query().build().find()
                val last = list.last()
                if (last.emLock == EmLock.lock) {
                    box.put(info)
                }
            }
        }
    }

}