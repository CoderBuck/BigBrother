package me.buck.bigbrother

import android.content.Context
import io.objectbox.Box
import io.objectbox.BoxStore

object ObjectBox {
    lateinit var boxStore: BoxStore
        private set

    fun init(context: Context) {
        boxStore = MyObjectBox.builder()
            .androidContext(context.applicationContext)
            .build()
    }

    fun screenLockInfoBox(): Box<ScreenLockInfo> {
        return boxStore.boxFor(ScreenLockInfo::class.java)
    }
}