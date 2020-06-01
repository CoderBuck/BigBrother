package me.buck.bigbrother.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import me.buck.bigbrother.R
import me.buck.bigbrother.adapter.holder.BaseHolder
import me.buck.bigbrother.databinding.ItemDevToolBinding
import me.buck.bigbrother.service.MyAccessibilityService
import me.buck.bigbrother.ui.PopManager
import me.buck.bigbrother.util.AccessibilityUtils

class DevToolAdapter() : RecyclerView.Adapter<DevToolAdapter.Holder>() {

    val items = mutableListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevToolAdapter.Holder {
        return Holder(parent, R.layout.item_dev_tool)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DevToolAdapter.Holder, position: Int) {
        holder.item = items[position]
        holder.binding.title.text = items[position]
    }

    @Suppress("UNUSED_ANONYMOUS_PARAMETER")
    class Holder(parent: ViewGroup, id: Int) : BaseHolder(parent, id) {
        val binding: ItemDevToolBinding = ItemDevToolBinding.bind(itemView)
        lateinit var item: String

        init {
            val context = itemView.context
            itemView.setOnClickListener {
                //如果在显示，就关掉
                if (PopManager.isTopActivityPopShowing()) {
                    PopManager.hideTopActivityPop()
                    return@setOnClickListener
                }

                val enable = AccessibilityUtils.checkEnable(itemView.context, MyAccessibilityService::class.java)
                if (!enable) {
                    // 弹窗 需要开启无障碍服务
                    MaterialAlertDialogBuilder(context)
                        .setTitle("无障碍权限")
                        .setMessage("需要在设置界面手动开启无障碍权限")
                        .setNegativeButton("取消") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .setPositiveButton("确定") { dialog, which ->
                            AccessibilityUtils.jumpSetting(context)
                            dialog.dismiss()
                        }
                        .show()
                    return@setOnClickListener
                }

                val grantedDrawOverlays = PermissionUtils.isGrantedDrawOverlays()
                if (!grantedDrawOverlays) {
                    // 弹窗 需要开启悬浮窗权限
                    MaterialAlertDialogBuilder(context)
                        .setTitle("悬浮窗权限")
                        .setMessage("需要在设置界面手动开启悬浮窗权限")
                        .setNegativeButton("取消") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .setPositiveButton("确定") { dialog, which ->
                            dialog.dismiss()
                            PermissionUtils.requestDrawOverlays(object : PermissionUtils.SimpleCallback {
                                override fun onGranted() {
                                    ToastUtils.showLong("悬浮窗权限已开启")
                                }

                                override fun onDenied() {
                                    ToastUtils.showLong("请开启悬浮窗权限")
                                }
                            })
                        }
                        .show()
                    return@setOnClickListener
                }

                // 显示弹窗
                PopManager.showTopActivityPop(itemView.context)
            }
        }

    }

}