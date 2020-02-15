package me.buck.bigbrother

import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager

/**
 * 广播接收器的简单封装，默认接收本地广播
 */
abstract class SimpleReceiver(
    var mContext: Context,
    var mIsLocal: Boolean = true)
    : BroadcastReceiver() {

    protected var mFilter = IntentFilter()


    fun register() {
        if (mIsLocal) {
            LocalBroadcastManager.getInstance(mContext).registerReceiver(this, mFilter)
        } else {
            mContext.registerReceiver(this, mFilter)
        }
    }

    fun unregister() {
        if (mIsLocal) {
            LocalBroadcastManager.getInstance(mContext).unregisterReceiver(this)
        } else {
            mContext.unregisterReceiver(this)
        }
    }
}