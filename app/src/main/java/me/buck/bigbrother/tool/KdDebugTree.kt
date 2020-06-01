package me.buck.bigbrother.tool

import timber.log.Timber

class KdDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String? {
        return "kd-" + super.createStackElementTag(element)
    }
}