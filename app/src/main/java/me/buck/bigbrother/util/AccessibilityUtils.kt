package me.buck.bigbrother.util

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.view.accessibility.AccessibilityManager

/**
 * 无障碍服务工具类
 */
object AccessibilityUtils {

    /**
     * 跳转到无障碍设置
     */
    fun jumpSetting(context: Context) {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 检查无障碍服务是否开启
     *
     * @param context
     * @param service 无障碍服务类
     */
    fun checkEnable(context: Context, service: Class<out AccessibilityService>): Boolean {
        val am = context.getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager
        // AccessibilityServiceInfo.FEEDBACK_ALL_MASK 这个要跟自己的服务配置一致
        val services = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
        services.forEach {
            // it.id = .buck.bigbrother/.MyAccessibilityService
            val serviceInfo = it.resolveInfo.serviceInfo
            if (serviceInfo.name == service.name) {
                return true
            }
        }
        return false
    }
}