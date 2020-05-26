package me.buck.bigbrother

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import me.buck.bigbrother.test.TestActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Starter.monitorService(this)


        button.setOnClickListener {
//            Thread {
//                val info = getLockInfo()
//                val lockCount = getLockCount()
//                runOnUiThread {
//                    text.text = info
//                    lock_count.text = "解锁次数：$lockCount"
//                }
//            }.start()

            startActivity(Intent(this,TestActivity::class.java))
        }
    }

    fun getLockInfo(): String {
        val box = ObjectBox.screenLockInfoBox()
        return box.all.joinToString(separator = "\n") { info ->
            info.time + "  " + info.emLock.name
        }
    }

    fun getLockCount(): Long {
        return ObjectBox.screenLockInfoBox().query()
            .contains(ScreenLockInfo_.emLock, EmLock.unlock.name)
            .build().count()
    }
}

