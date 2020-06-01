package me.buck.bigbrother.ui

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.WindowManager

class TopActivityPop(private val mContext: Context) {

    val view = TopActivityView(mContext)
    private val mParams = WindowManager.LayoutParams()
    private val mWindowManager = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    var isShowing = false


    init {
        initParams()
    }

    private fun initParams() {
        mParams.width = WindowManager.LayoutParams.MATCH_PARENT
        mParams.height = 200
        mParams.gravity = Gravity.TOP or Gravity.START
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
        } else {
            mParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        }
        mParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
        mParams.format = PixelFormat.TRANSPARENT
        mParams.x = 0
        mParams.y = 0
    }

    fun show() {
        if (!isShowing) {
            mWindowManager.addView(view, mParams)
            isShowing = true
        }
    }

    fun hide() {
        if (isShowing) {
            mWindowManager.removeView(view)
            isShowing = false
        }
    }
}