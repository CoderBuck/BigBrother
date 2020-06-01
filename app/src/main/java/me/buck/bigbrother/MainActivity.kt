package me.buck.bigbrother

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import me.buck.bigbrother.adapter.DevToolAdapter
import me.buck.bigbrother.databinding.ActivityMainBinding
import me.buck.bigbrother.util.contentView

class MainActivity : AppCompatActivity() {

    val adapter = DevToolAdapter()

    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind = ActivityMainBinding.bind(contentView)

        bind.rv.layoutManager = GridLayoutManager(this, 4)
        bind.rv.adapter = adapter

        adapter.items.add("当前Activity")
        adapter.notifyDataSetChanged()

    }
}

