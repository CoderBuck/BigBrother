package me.buck.bigbrother

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Starter.monitorService(this)

        button.setOnClickListener {
            Thread {
                val infos = getLockInfos()
                runOnUiThread {
                    text.text = infos
                }
            }.start()
        }
    }

    fun getLockInfos(): String {
        val box = ObjectBox.screenLockInfoBox()
        val text = box.all
            .map { info ->
                info.time + "  " + info.emLock.name
            }
            .joinToString(separator = "\n")
        return text
    }
}
