package me.buck.bigbrother.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.coderbuck.boring.util.contentView
import me.buck.bigbrother.R
import me.buck.bigbrother.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var bind:ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        bind = ActivityTestBinding.bind(contentView)
    }
}