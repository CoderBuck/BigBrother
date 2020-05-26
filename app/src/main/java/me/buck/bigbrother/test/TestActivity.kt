package me.buck.bigbrother.test

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.PermissionInfoCompat
import com.blankj.utilcode.constant.PermissionConstants
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.ToastUtils
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.github.coderbuck.boring.util.contentView
import me.buck.bigbrother.R
import me.buck.bigbrother.databinding.ActivityTestBinding
import timber.log.Timber
import java.util.jar.Manifest

class TestActivity : AppCompatActivity() {

    private lateinit var bind: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        bind = ActivityTestBinding.bind(contentView)

        permissionReq()

        android.Manifest.permission.ACCEPT_HANDOVER


        PermissionUtils.isGranted()


    }

    private fun permissionReq() {
        PermissionUtils.permission(PermissionConstants.LOCATION)
            .rationale(PermissionUtils.OnRationaleListener { activity, shouldRequest ->
                Timber.d("rationale activity = ${activity.javaClass.simpleName}")
                Timber.d("rationale shouldRequest")
                ToastUtils.showLong("rationale")

                MaterialAlertDialogBuilder(activity)
                    .setTitle("权限请求")
                    .setMessage("rationale 解释")
                    .setNegativeButton("取消") { dialog, _ ->
                        shouldRequest.again(false)
                        dialog.dismiss()
                    }
                    .setPositiveButton("确定") { _, _ ->
                        shouldRequest.again(true)
                    }
                    .show()

            })
            .callback(object : PermissionUtils.FullCallback {
                override fun onGranted(granted: MutableList<String>) {
                    Timber.d("onGranted = $granted")
                }

                override fun onDenied(
                    deniedForever: MutableList<String>,
                    denied: MutableList<String>
                ) {
                    Timber.d("onDenied deniedForever = $deniedForever")
                    Timber.d("onDenied denied = $denied")

                    if (deniedForever.isNotEmpty()) {
                        ToastUtils.showLong("永远拒绝")
//                        bind.root.postDelayed(Runnable {
//                            PermissionUtils.launchAppDetailsSettings()
//                        }, 3000)

                        MaterialAlertDialogBuilder(this@TestActivity)
                            .setTitle("权限请求")
                            .setMessage("deniedForever 去设置打开")
                            .setNegativeButton("取消") { dialog, _ ->
                                dialog.dismiss()
                            }
                            .setPositiveButton("确定") { _, _ ->
                                PermissionUtils.launchAppDetailsSettings()
                            }
                            .show()
                    }
                }
            })
            .theme(PermissionUtils.ThemeCallback {
                it.setTheme(R.style.AppTheme_UtilsTransActivity)
            })
            .request()
    }
}