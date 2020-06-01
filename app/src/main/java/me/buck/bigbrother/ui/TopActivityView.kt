package me.buck.bigbrother.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import me.buck.bigbrother.app.AppModel
import me.buck.bigbrother.databinding.ViewTopActivityBinding

class TopActivityView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val binding = ViewTopActivityBinding.inflate(LayoutInflater.from(context), this, true)


    fun setPkg(pkg: String) {
        binding.pkg.text = pkg
    }

    fun setClazz(clazz: String) {
        binding.clazz.text = clazz
    }
}