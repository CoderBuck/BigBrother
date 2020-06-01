package me.buck.bigbrother

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.buck.bigbrother.databinding.ActivityMainBinding
import me.buck.bigbrother.util.AccessibilityUtils
import me.buck.bigbrother.util.contentView
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.bind(contentView)

        bind.fgRoot.setOnClickListener {
            //            AccessibilityUtils.jumpSetting(this)
            val enable = AccessibilityUtils.checkEnable(this, MyAccessibilityService::class.java)
            Timber.d("enable = %s", enable)
        }
    }
}

