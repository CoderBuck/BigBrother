package me.buck.bigbrother

import android.content.Intent




object Actions {

    /* 开关机 */
    var BOOT_COMPLETED = Intent.ACTION_BOOT_COMPLETED
    var SHUTDOWN = Intent.ACTION_SHUTDOWN

    /* 锁屏、亮屏、解锁*/
    var SCREEN_OFF = Intent.ACTION_SCREEN_OFF
    var SCREEN_ON = Intent.ACTION_SCREEN_ON
    var USER_PRESENT = Intent.ACTION_USER_PRESENT
}