package me.buck.bigbrother.ui

import android.content.Context

object PopManager {

    var topActivityPop: TopActivityPop? = null

    fun showTopActivityPop(context: Context) {
        if (topActivityPop == null) {
            topActivityPop = TopActivityPop(context)
        }
        topActivityPop!!.show()
    }

    fun hideTopActivityPop() {
        topActivityPop?.hide()
    }

    fun isTopActivityPopShowing() = topActivityPop?.isShowing ?: false


}