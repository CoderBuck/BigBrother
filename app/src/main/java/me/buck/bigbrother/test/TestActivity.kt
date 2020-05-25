package me.buck.bigbrother.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.constant.PermissionConstants
import com.blankj.utilcode.util.PermissionUtils
import com.blankj.utilcode.util.Utils
import io.github.coderbuck.boring.util.contentView
import me.buck.bigbrother.R
import me.buck.bigbrother.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var bind: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        bind = ActivityTestBinding.bind(contentView)

        PermissionUtils.permission(PermissionConstants.CALENDAR)
            .rationale(PermissionUtils.OnRationaleListener { activity, shouldRequest ->
            })
            .callback(object : PermissionUtils.FullCallback {
                override fun onGranted(granted: MutableList<String>) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDenied(
                    deniedForever: MutableList<String>,
                    denied: MutableList<String>
                ) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            .request()
    }
}